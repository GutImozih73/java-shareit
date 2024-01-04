package ru.practicum.shareit.item.mapper;

import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.model.Item;

/**
 * Класс-маппер для приведения DTO сущностей в POJO объекты и наоборот
 */
public class ItemMapper {

    /**
     * Метод для приведения объекта класса Item к объекту класса ItemDto
     * @param item товар приводимый к объекту класса Item
     * @return возвращает объект класса ItemDto
     */
    public ItemDto toItemDto(Item item) {
        return new ItemDto(item.getId(), item.getName(), item.getDescription(), item.getAvailable(),
                item.getOwner(), item.getIsRequested());
    }

    /**
     * Метод для приведения объекта класса ItemDto к объекту класса Item
     * @param item товар приводимый к объекту класса Item
     * @return возвращает объект класса Item
     */
    public Item toItem(ItemDto item) {
        return new Item(item.getId(), item.getName(), item.getDescription(), item.getAvailable(),
                item.getOwner(), item.getIsRequested());
    }
}