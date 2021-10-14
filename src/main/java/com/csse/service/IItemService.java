package com.csse.service;

import com.csse.model.Item;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.SQLException;
import java.util.List;

public interface IItemService {
    //add item method
    boolean addItem(Item item);

    //edit item method
    Item editItem(String item) throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException;

    //Update items
    boolean updateItem(Item item);

    //delete items method
    int deleteItem(Item item);

    List<Item> getItem() throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException;
}
