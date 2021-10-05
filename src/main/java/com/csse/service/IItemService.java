package com.csse.service;

import com.csse.model.Item;

public interface IItemService {
    //add item method
    void addItem(Item item);
    //edit item method
    int editItem(Item item);
    //delete items method
    int deleteItem(Item item);
}
