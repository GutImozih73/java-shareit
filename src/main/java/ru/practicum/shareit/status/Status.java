package ru.practicum.shareit.status;

/**
 * Перечисления статуса заказа при бронировании
 */
public enum Status {
    /**
     * Новое бронирование, ожидающее одобрения
     */
    WAITING,
    /**
     * Подтверждённое бронирование владельцем
     */
    APPROVED,
    /**
     * Отклонённое бронирование владельцем
     */
    REJECTED,
    /**
     * Отклонённое бронирование создателем
     */
    CANCELED
}