package ru.practicum.shareit.exception.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Класс-модель для создания объекта ответа ошибки
 */
@RequiredArgsConstructor
@Getter
public class ErrorResponse {
    /**
     * Строка с сообщением ошибки
     */
    private final String error;
}