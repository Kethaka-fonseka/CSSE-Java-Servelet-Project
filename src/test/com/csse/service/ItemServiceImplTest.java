package com.csse.service;

import com.csse.model.Item;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceImplTest {



    @Test
    void addItem() {

        Item item=new Item();
        IItemService itemService=new ItemServiceImpl();

        item.setItemName("Cement");
        item.setItemCode("001-Cement");
        item.setQuantity(100);
        item.setPrice(100000);
        item.setSupplierId(2);

        boolean actual_result =itemService.addItem(item);

        assertEquals(true,actual_result);

    }

    @Test
    void editItem() throws SQLException, ParserConfigurationException, ClassNotFoundException, SAXException {


        Item item=new Item();
        IItemService itemService=new ItemServiceImpl();

        item.setItemId("32");
        Item actual_result =itemService.editItem("32");

        assertEquals(item.getItemId(),actual_result.getItemId());

    }

    @Test
    void updateItem() {

        Item item=new Item();
        IItemService itemService=new ItemServiceImpl();

        item.setItemId("33");
        item.setItemName("Glass");
        item.setItemCode("005-Glass");
        item.setQuantity(50);
        item.setPrice(120000);

        boolean actual_result =itemService.updateItem(item);

        assertEquals(true,actual_result);

    }

    @Test
    void deleteItem() {

        Item item=new Item();
        IItemService itemService=new ItemServiceImpl();

        item.setItemId("32");
        int actual_result =itemService.deleteItem(item);

        assertEquals(1,actual_result);

    }

    @Test
    void getItem() throws SQLException, ParserConfigurationException, ClassNotFoundException, SAXException {


        IItemService iItemService = new ItemServiceImpl();
        List<Item> actual_result = iItemService.getItem();

        assertEquals("21",actual_result.get(0).getItemId());
        assertEquals("22",actual_result.get(1).getItemId());
        assertEquals("27",actual_result.get(2).getItemId());
        assertEquals("28",actual_result.get(3).getItemId());
    }
}