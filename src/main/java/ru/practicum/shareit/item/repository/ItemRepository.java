package ru.practicum.shareit.item.repository;

import ru.practicum.shareit.item.dto.ItemDto;

import java.util.List;

/**
 * Класс-хранилище данных о товарах
 */
public interface ItemRepository {
    /**
     * Метод создаёт новый товар и сохраняет его в хранилище
     * @param item сохраняемый товар
     * @return возвращает сохранённый товар
     */
    ItemDto createItem(ItemDto item);
    /**
     * Метод сохраняет данные о товарах пользователя
     * @param userId идентификатор пользователя
     * @param itemId идентификатор товара
     */

    void saveUsersItems(Long userId, Long itemId);
    /**
     * Метод проверяет, принадлежит ли товар пользователю
     * @param userId идентификатор пользователя
     * @param itemId идентификатор товара
     * @return возвращает true или false
     */

    boolean isUsersItem(Long userId, Long itemId);
    /**
     * Метод обновляет данные о товаре в хранилище
     * @param item обновляемый товар
     * @return возвращает обновлённый товар
     */

    ItemDto updateItem(Long itemId, ItemDto item);
    /**
     * Метод возвращает товар по его идентификатору
     * @param id идентификатор товара
     * @return возвращает найденный товар из хранилища
     */

    ItemDto getItemById(Long id);
    /**
     * Метод удаляет товар из хранилища по его идентификатору
     * @param id идентификатор товара
     */

    void deleteItemById(Long id);
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