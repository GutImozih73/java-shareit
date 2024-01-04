package ru.practicum.shareit.user.mapper;

import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.model.User;

/**
 * Класс-маппер для приведения DTO сущностей в POJO объекты и наоборот
 */
public class UserMapper {

    /**
     * Метод для приведения объекта класса User к объекту класса UserDto
     * @param user пользователь приводимый к объекту класса UserDto
     * @return возвращает объект класса UserDto
     */
    public UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    /**
     * Метод для приведения объекта класса UserDto к объекту класса User
     * @param user пользователь приводимый к объекту класса User
     * @return возвращает объект класса User
     */
    public User toUser(UserDto user) {
        return new User(user.getId(), user.getName(), user.getEmail());
    }
}