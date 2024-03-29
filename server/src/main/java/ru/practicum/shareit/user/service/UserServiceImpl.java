package ru.practicum.shareit.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.shareit.exception.ObjectAlreadyExistsException;
import ru.practicum.shareit.exception.ObjectNotFoundException;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.mapper.UserMapper;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service("ServerUserService")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Transactional
    @Override
    public UserDto create(UserDto user) {
        try {
            User thisUser = mapper.toUser(user);
            return mapper.toUserDto(repository.save(thisUser));
        } catch (DataIntegrityViolationException exception) {
            throw new ObjectAlreadyExistsException("Данные о пользователе уже есть в системе");
        }
    }

    @Transactional
    @Override
    public UserDto update(Long id, UserDto user) {
        User thisUser = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Пользователь не найден"));
        if (user.getEmail() != null && !user.getEmail().isBlank()) {
            thisUser.setEmail(user.getEmail());
        }
        if (user.getName() != null && !user.getName().isBlank()) {
            thisUser.setName(user.getName());
        }
        return mapper.toUserDto(thisUser);
    }

    @Override
    public UserDto getById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Пользователь не найден"));
        return mapper.toUserDto(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserDto> getUsers() {
        return repository.findAll().stream().map(mapper::toUserDto).collect(Collectors.toList());
    }
}