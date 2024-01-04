package ru.practicum.shareit.user.repository;

import org.springframework.stereotype.Repository;
import ru.practicum.shareit.exception.ObjectAlreadyExistsException;
import ru.practicum.shareit.exception.ObjectNotFoundException;
import ru.practicum.shareit.exception.ValidationException;
import ru.practicum.shareit.user.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private Long id = 0L;

    @Override
    public User create(User user) {
        if (user.getEmail() == null) {
            throw new ValidationException("Невалидный почтовый ящик");
        }
        for (Map.Entry<Long, User> entry: users.entrySet()) {
            User thisUser = entry.getValue();
            if (user.getEmail().equals(thisUser.getEmail())) {
                throw new ObjectAlreadyExistsException("Почтовый ящик уже есть в системе");
            }
        }
        Long id = increment();
        user.setId(id);
        users.put(id, user);
        return users.get(id);
    }

    @Override
    public User update(Long id, User user) {
        User thisUser = users.get(id);
        if (user.getEmail() != null) {
            if (!user.getEmail().equals(thisUser.getEmail())) {
                for (Map.Entry<Long, User> entry : users.entrySet()) {
                    User currentUser = entry.getValue();
                    if (user.getEmail().equals(currentUser.getEmail())) {
                        throw new ObjectAlreadyExistsException("Почтовый ящик уже есть в системе");
                    }
                }
                thisUser.setEmail(user.getEmail());
            }
        }
        if (user.getName() != null) {
            thisUser.setName(user.getName());
        }
        users.put(id, thisUser);
        return users.get(id);
    }

    @Override
    public User getById(Long id) {
        if (id == null || !users.containsKey(id)) {
            throw new ObjectNotFoundException("Пользователя с подобным идентификатором не существует");
        }
        return users.get(id);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null || !users.containsKey(id)) {
            throw new ValidationException("Пользователя с подобным идентификатором не существует");
        }
        users.remove(id);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    private Long increment() {
        return ++id;
    }
}