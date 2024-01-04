package ru.practicum.shareit.item.service;

import ru.practicum.shareit.item.dto.ItemDto;

import java.util.List;

/**
 * Класс-сервис для управления сущностями товаров
 */
public interface ItemService {
    /**
     * Метод создаёт новый товар и сохраняет его в хранилище
     * @param userId идентификатор пользователя
     * @param item сохраняемый товар
     * @return возвращает сохранённый товар
     */
    ItemDto createItem(Long userId, ItemDto item);
    /**
     * Метод обновляет данные о товаре в хранилище
     * @param userId идентификатор пользователя
     * @param item обновляемый товар
     * @return возвращает обновлённый товар
     */

    ItemDto updateItem(Long userId, Long itemId, ItemDto item);
    /**
     * Метод возвращает товар по его идентификатору
     * @param userId идентификатор пользователя
     * @param id идентификатор товара
     * @return возвращает найденный товар из хранилища
     */

    ItemDto getItemById(Long userId, Long id);
    /**
     * Метод удаляет товар из хранилища по его идентификатору
     * @param userId идентификатор пользователя
     * @param id идентификатор товара
     */

    void deleteItemById(Long userId, Long id);
    /**
     * Метод возвращает список товаров определённого пользователя
     * @param id идентификатор пользователя
     * @return возвращает лист с товарами
     */

    List<ItemDto> getItemsByUserId(Long id);
    /**
     * Метод поиска товара в хранилище по ключевым словам
     * @param text ключевые слова по которым идёт поиск
     * @return возвращает список товаров, в которых найдены ключевые слова
     */

    List<ItemDto> search(String text);
}