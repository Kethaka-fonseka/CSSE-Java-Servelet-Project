package com.csse.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.xml.parsers.ParserConfigurationException;
import com.csse.model.Item;
import org.xml.sax.SAXException;
import com.csse.util.CommonConstants;
import com.csse.util.DBConnectionUtil;
import com.csse.util.QueryUtil;
import java.util.logging.Logger;


public class ItemServiceImpl implements IItemService {

    private static Connection connection;
    private PreparedStatement preparedStatement;

    /** Initialise logger */
    public static final Logger log = Logger.getLogger(ItemServiceImpl.class.getName());


    /**
     * addItem  function is used to add new items to the system
     * @param item
     */
    @Override
    public void addItem(Item item) {

        try {
            // get database connection from DBConnection class in DBConnection package
            connection = DBConnectionUtil.getDBConnection();


            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ITEMS));

            connection.setAutoCommit(false);

            // assign values
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemName());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getItemCode());
            preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, item.getQuantity());
            preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FOUR, item.getPrice());

            preparedStatement.execute();
            connection.commit();

        } catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
                 log.log(Level.SEVERE, e.getMessage());
    }
        finally {
            /*
             * Close prepared statement and database connectivity at the end of
             * insert
             */
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                log.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    /**
     * editItem function is used to update already added items
     * @param item
     * @return result
     */
    @Override
    public int editItem(Item item) {
        int result = 0;

        try {
            // get database connection from DBConnection class in DBConnection package
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ITEM));

            connection.setAutoCommit(false);

            // assign values
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemName());
            preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, item.getQuantity());
            preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_THREE, item.getPrice());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, item.getItemCode());
            result = preparedStatement.executeUpdate();

            connection.commit();
            return result;

        } catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
            log.log(Level.SEVERE, e.getMessage());
            result = 0;
            return result;
        }
        finally {
            /*
             * Close prepared statement and database connectivity at the end of
             * update
             */
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                log.log(Level.SEVERE, e.getMessage());
            }
        }

    }

    /**
     * Delete Items function is used to delete items from the database
     * @param item
     * @return deleteItems
     */
    @Override
    public int deleteItem(Item item) {
        int result = 0;

        try {
            // get database connection from DBConnection class in DBConnection package
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ITEM));

            connection.setAutoCommit(false);

            // assign values
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemCode());
            result = preparedStatement.executeUpdate();
            preparedStatement.executeUpdate();

            connection.commit();
            return result;

        } catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
            log.log(Level.SEVERE, e.getMessage());
            return 0;
        }
        finally {
            /*
             * Close prepared statement and database connectivity at the end of
             * the deletion
             */
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                log.log(Level.SEVERE, e.getMessage());
            }
        }
    }


    /**
     * getItem function is used to display all item
     * @return ItemList
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public static List<Item> getItem() throws ClassNotFoundException, SQLException, IOException, ParserConfigurationException, SAXException {

        ArrayList<Item> items = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        String itemID = null;
        String itemName=null;
        String itemCode = null;
        int quantity = 0;
        double price = 0;

    try{
        connection = DBConnectionUtil.getDBConnection();

        preparedStatement = connection
                .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_GET_ITEM));

        connection.setAutoCommit(false);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            itemID = rs.getString(CommonConstants.COLUMN_INDEX_ONE);
            itemName = rs.getString(CommonConstants.COLUMN_INDEX_TWO);
            itemCode = rs.getString(CommonConstants.COLUMN_INDEX_THREE);
            quantity = rs.getInt(CommonConstants.COLUMN_INDEX_FOUR);
            price = rs.getDouble(CommonConstants.COLUMN_INDEX_FIVE);
        }

        Item item=new Item();

        item.setItemId(itemID);
        item.setItemCode(itemCode);
        item.setItemName(itemName);
        item.setQuantity(quantity);
        item.setPrice(price);

        items.add(item);


    } catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
        log.log(Level.SEVERE, e.getMessage());
    }
        finally {
        /*
         * Close prepared statement and database connectivity at the end of
         * the retrieve
         */
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }
        return items;
    }


    }


