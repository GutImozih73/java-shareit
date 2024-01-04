package ru.practicum.shareit.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.practicum.shareit.exception.ObjectAlreadyExistsException;
import ru.practicum.shareit.exception.ObjectNotFoundException;
import ru.practicum.shareit.exception.ValidationException;
import ru.practicum.shareit.exception.model.ErrorResponse;

/**
 * Класс-обработчик исключений серверных ошибок
 */
@RestControllerAdvice
public class ErrorHandler {

    /**
     * Метод для обработки исключения 404
     * @param exception возникающая ошибка
     * @return возвращаемый ответ
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleObjectNotFoundException(final ObjectNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    /**
     * Метод для обработки исключения 400
     * @param exception возникающая ошибка
     * @return возвращаемый ответ
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(final ValidationException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    /**
     * Метод для обработки исключения 500
     * @param exception возникающая ошибка
     * @return возвращаемый ответ
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleObjectAlreadyExistsException(final ObjectAlreadyExistsException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}