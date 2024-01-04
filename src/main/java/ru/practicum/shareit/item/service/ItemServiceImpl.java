package ru.practicum.shareit.item.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.exception.ObjectNotFoundException;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.repository.ItemRepository;
import ru.practicum.shareit.user.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Override
    public ItemDto createItem(Long userId, ItemDto item) {
        ItemDto thisItem = new ItemDto();
        if (userRepository.getById(userId) != null) {
            thisItem = itemRepository.createItem(item);
            itemRepository.saveUsersItems(userId, thisItem.getId());
        }
        return thisItem;
    }

    @Override
    public ItemDto updateItem(Long userId, Long itemId, ItemDto item) {
        ItemDto thisItem = new ItemDto();
        if (userRepository.getById(userId) != null && itemRepository.getItemById(itemId) != null) {
            if (itemRepository.isUsersItem(userId, itemId)) {
                thisItem = itemRepository.updateItem(itemId, item);
            } else {
                throw new ObjectNotFoundException("Пользователь не является владельцем товара");
            }
        }
        return thisItem;
    }

    @Override
    public ItemDto getItemById(Long userId, Long id) {
        return itemRepository.getItemById(id);
    }

    @Override
    public void deleteItemById(Long userId, Long id) {
        itemRepository.deleteItemById(id);
    }

    @Override
    public List<ItemDto> getItemsByUserId(Long id) {
        return itemRepository.getItemsByUserId(id);
    }

    @Override
    public List<ItemDto> search(String text) {
        return itemRepository.search(text);
    }
}