package ru.practicum.shareit.item.repository;

import org.springframework.stereotype.Repository;
import ru.practicum.shareit.exception.ObjectNotFoundException;
import ru.practicum.shareit.item.dto.ItemDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private final Map<Long, ItemDto> items = new HashMap<>();
    private final Map<Long, Long> usersItems = new HashMap<>();
    private Long id = 0L;

    @Override
    public ItemDto createItem(ItemDto item) {
        Long id = increment();
        item.setId(id);
        items.put(id, item);
        return items.get(id);
    }

    @Override
    public void saveUsersItems(Long userId, Long itemId) {
        usersItems.put(userId, itemId);
    }

    @Override
    public boolean isUsersItem(Long userId, Long itemId) {
        boolean isUsersItem = false;
        for (Map.Entry<Long, Long> entry: usersItems.entrySet()) {
            if (entry.getKey().equals(userId) && entry.getValue().equals(itemId)) {
                isUsersItem = true;
                break;
            }
        }
        return isUsersItem;
    }

    @Override
    public ItemDto updateItem(Long itemId, ItemDto item) {
        ItemDto thisItem = items.get(itemId);
        if (item.getName() != null) {
            thisItem.setName(item.getName());
        }
        if (item.getDescription() != null) {
            thisItem.setDescription(item.getDescription());
        }
        if (item.getAvailable() != null) {
            thisItem.setAvailable(item.getAvailable());
        }
        return items.put(thisItem.getId(), thisItem);
    }

    @Override
    public ItemDto getItemById(Long id) {
        if (!items.containsKey(id)) {
            throw new ObjectNotFoundException(format("Товар с идентификатором %d не найден", id));
        }
        return items.get(id);
    }

    @Override
    public void deleteItemById(Long id) {
        if (usersItems.containsValue(id)) {
            for (Map.Entry<Long, Long> entry: usersItems.entrySet()) {
                Long userId = entry.getKey();
                Long itemId = entry.getValue();
                usersItems.remove(userId, itemId);
            }
        }
        items.remove(id);
    }

    @Override
    public List<ItemDto> getItemsByUserId(Long id) {
        List<ItemDto> itemsList = new ArrayList<>();
        for (Map.Entry<Long, Long> entry: usersItems.entrySet()) {
            Long userId = entry.getKey();
            Long itemId = entry.getValue();
            if (id.equals(userId)) {
                itemsList.add(getItemById(itemId));
            }
        }
        return itemsList;
    }

    @Override
    public List<ItemDto> search(String text) {
        List<ItemDto> itemsList = new ArrayList<>();
        if (!text.isBlank()) {
            for (Map.Entry<Long, ItemDto> entry : items.entrySet()) {
                ItemDto item = entry.getValue();
                if (item.getName().toLowerCase().contains(text.toLowerCase())
                        || item.getDescription().toLowerCase().contains(text.toLowerCase())) {
                    if (item.getAvailable().equals(true)) {
                        itemsList.add(item);
                    }
                }
            }
        }
        return itemsList;
    }

    private Long increment() {
        return ++id;
    }
}