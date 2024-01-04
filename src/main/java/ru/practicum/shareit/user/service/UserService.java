package ru.practicum.shareit.user.service;

import ru.practicum.shareit.user.model.User;

import java.util.List;

/**
 * Класс-сервис для управления сущностями пользователей
 */
public interface UserService {
    /**
     * Метод создаёт пользователя и добавляет его в хранилище
     * @param user данные пользователя
     * @return возвращает созданного пользователя
     */
    User create(User user);
    /**
     * Метод обновляет данные пользователя в хранилище
     * @param id идентификатор пользователя
     * @return возвращает новые данные о пользователе
     */

    User update(Long id, User user);
    /**
     * Метод получения пользователя по идентификатору
     * @param id идентификатор пользователя
     * @return возвращает полученного пользователя
     */

    User getById(Long id);
    /**
     * Метод удаления пользователя по идентификатору
     * @param id идентификатор пользователя
     */

    void deleteById(Long id);
    /**
     * Метод получения списка пользователей
     * @return возвращает список пользователей из хранилища
     */

    List<User> getUsers();
}