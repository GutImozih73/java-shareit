package ru.practicum.shareit.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

/**
 * Класс-модель для создания объекта пользователя
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    @Email(message = "Невалидный почтовый ящик")
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}