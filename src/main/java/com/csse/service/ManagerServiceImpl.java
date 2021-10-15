package com.csse.service;

import com.csse.model.Manager;
import com.csse.util.CommonConstants;
import com.csse.util.CommonUtil;
import com.csse.util.DBConnectionUtil;
import com.csse.util.QueryUtil;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerServiceImpl implements IManagerService {
    public static final Logger log = Logger.getLogger(ManagerServiceImpl.class.getName());
    private static Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public boolean addManager(Manager Manager) {
        boolean res = false;

        String userID = CommonUtil.generateUID(getUserIDs());
        try {
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_USER));

            connection.setAutoCommit(false);

            Manager.setUserId(userID);

            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, Manager.getUserId());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, Manager.getUserRole());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, Manager.getUserName());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, Manager.getUserMail());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, Manager.getUserPass());
            boolean result = preparedStatement.execute();
            connection.commit();
            if(!result){
                connection = DBConnectionUtil.getDBConnection();
                preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_MANAGER));
                preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, Manager.getMobileNumber());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, Manager.getSiteName());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, Manager.getUserId());
                res = preparedStatement.execute();
                connection.commit();
            }else{
                System.out.println("Error");
            }


        }catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
            log.log(Level.SEVERE, e.getMessage());
        } finally {
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

        return res;
    }

    @Override
    public Manager getManagerByID(String userID) {
        return actionOnManager(userID).get(0);
    }

    /**
     * @return
     */
    @Override
    public ArrayList<Manager> getManager() {
        return actionOnManager(null);
    }


    /**
     * @param userID
     * @return
     */

    private ArrayList<Manager> actionOnManager(String userID) {

        ArrayList<Manager> userList = new ArrayList<>();
        try {
            connection = DBConnectionUtil.getDBConnection();
            if (userID != null && !userID.isEmpty()) {

                preparedStatement = connection
                        .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_MANAGER));
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);

            }
            else {
                preparedStatement = connection
                        .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_MANAGERS));
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Manager Manager = new Manager();

                Manager.setUserId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
                Manager.setUserRole(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
                Manager.setUserName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
                Manager.setUserMail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
                Manager.setUserPass(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
                Manager.setManagerId(resultSet.getInt(CommonConstants.COLUMN_INDEX_SIX));
                Manager.setSiteName(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
                Manager.setMobileNumber(resultSet.getInt(CommonConstants.COLUMN_INDEX_EIGHT));
                userList.add(Manager);
            }


        } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
            log.log(Level.SEVERE, e.getMessage());
        } finally {
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
        return userList;
    }

    @Override
    public ArrayList<String> getUserIDs(){

        ArrayList<String> arrayList = new ArrayList<>();
        try {
            connection = DBConnectionUtil.getDBConnection();
            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_USER_IDS));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
            }
        } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
            log.log(Level.SEVERE, e.getMessage());
        } finally {
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
        return arrayList;
    }

    @Override
    public boolean removeManager(String userID) {

        boolean status = false;
        if (userID != null && !userID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_MANAGER_1));
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
                int i = preparedStatement.executeUpdate();
                if(i != 0){
                    preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_MANAGER_2));
                    preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
                    int r = preparedStatement.executeUpdate();
                    if(r != 0){
                        status =true;
                    }
                }
            } catch (SQLException | SAXException | IOException | ParserConfigurationException
                    | ClassNotFoundException e) {
                log.log(Level.SEVERE, e.getMessage());
            } finally {
                /*
                 * Close prepared statement and database connectivity at the end
                 * of transaction
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
        return status;
    }

    @Override
    public boolean updateManager(String userID, Manager Manager) {
        boolean res =false;
        if (userID != null && !userID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                preparedStatement = connection
                        .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_MANAGER));

                preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, Manager.getUserName());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, Manager.getUserMail());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, Manager.getUserPass());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, Manager.getSiteName());
                preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, Manager.getMobileNumber());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, userID);
                int i  =preparedStatement.executeUpdate();
                if(i!=0){
                    res = true;
                }


            } catch (SQLException | SAXException | IOException | ParserConfigurationException
                    | ClassNotFoundException e) {
                log.log(Level.SEVERE, e.getMessage());
            } finally {
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
        return res;
    }


}
