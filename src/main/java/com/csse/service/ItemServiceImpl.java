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
     * @return
     */
    @Override
    public boolean addItem(Item item) {

        try {
            // get database connection from DBConnection class in DBConnection package
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ITEMS));

            connection.setAutoCommit(false);

            // assign values
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemName());
            preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, item.getQuantity());
            preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_THREE, item.getPrice());
            preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, item.getSupplierId());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, item.getItemCode());
            preparedStatement.execute();
            connection.commit();
            return true;

        } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
                 log.log(Level.SEVERE, e.getMessage());
                  return false;
        } finally {
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
     * @return result
     */
    @Override
     public Item editItem(String itemId) throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException {

        ArrayList<Item> items = new ArrayList<>();

        try {
            // get database connection from DBConnection class in DBConnection package
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM));

            connection.setAutoCommit(false);
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,itemId);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {

                Item item=new Item();

                item.setItemId(result.getString(CommonConstants.COLUMN_INDEX_ONE));
                item.setItemName(result.getString(CommonConstants.COLUMN_INDEX_TWO));
                item.setQuantity(result.getInt(CommonConstants.COLUMN_INDEX_THREE));
                item.setPrice(result.getDouble(CommonConstants.COLUMN_INDEX_FOUR));
                int foreignKey= result.getInt(CommonConstants.COLUMN_INDEX_FIVE);
                item.setItemCode(result.getString(CommonConstants.COLUMN_INDEX_SIX));

                items.add(item);
            }
            System.out.println("RUN PROPERLY");

        } catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
            log.log(Level.SEVERE, e.getMessage());

            System.out.println("ERROR HERE RUN");
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
        return  items.get(0);
    }

    @Override
    public boolean updateItem(Item item) {

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
            preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, Integer.parseInt(item.getItemId()));
            preparedStatement.executeUpdate();
            connection.commit();
            return true;

        } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
            log.log(Level.SEVERE, e.getMessage());
            return false;

        } finally {
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
     * Delete Items function is used to delete items from the database
     * @param item
     * @return deleteItems
     */
    @Override
    public int deleteItem(Item item) {
        int result;

        try {
            // get database connection from DBConnection class in DBConnection package
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ITEM));

            connection.setAutoCommit(false);

            // assign values
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemId());
            result = preparedStatement.executeUpdate();
            connection.commit();

            return result;

        } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
     *
     * @return List<Item>
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws ParserConfigurationException
     * @throws SAXException
     */

    public List<Item> getItem() throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException {

        ArrayList<Item> items = new ArrayList<>();

    try{
        connection = DBConnectionUtil.getDBConnection();

        preparedStatement = connection
                .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_GET_ITEM));

        connection.setAutoCommit(false);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            Item item=new Item();

            item.setItemId(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
            item.setItemName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
            item.setQuantity(rs.getInt(CommonConstants.COLUMN_INDEX_THREE));
            item.setPrice(rs.getDouble(CommonConstants.COLUMN_INDEX_FOUR));
            item.setSupplierId(rs.getInt(CommonConstants.COLUMN_INDEX_FIVE));
            item.setItemCode(rs.getString(CommonConstants.COLUMN_INDEX_SIX));

            items.add(item);
        }
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


