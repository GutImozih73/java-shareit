package ru.practicum.shareit.item.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.user.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Класс-модель для создания объекта товара
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Long id;
    @NotNull(message = "Поле названия товара не должно быть пустым")
    @NotBlank(message = "Поле названия товара не может состоять из пробелов")
    private String name;
    @NotNull(message = "Поле описания товара не должно быть пустым")
    private String description;
    @NotNull(message = " Поле статуса доступности не может быть пустым")
    private Boolean available;
    private User owner;
    private Boolean isRequested;
}