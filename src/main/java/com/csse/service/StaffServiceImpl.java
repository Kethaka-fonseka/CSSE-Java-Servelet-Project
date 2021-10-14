package com.csse.service;

import com.csse.model.Staff;
import com.csse.model.Staff;
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

public class StaffServiceImpl implements IStaffService {
    public static final Logger log = Logger.getLogger(StaffServiceImpl.class.getName());
    private static Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public boolean addStaff(Staff staff) {
        boolean res = false;

        String userID = CommonUtil.generateUID(getUserIDs());
        try {
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_USER));

            connection.setAutoCommit(false);

            staff.setUserId(userID);

            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, staff.getUserId());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, staff.getUserRole());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, staff.getUserName());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, staff.getUserMail());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, staff.getUserPass());
            boolean result = preparedStatement.execute();
            connection.commit();
            if(!result){
                connection = DBConnectionUtil.getDBConnection();
                preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_STAFF));
                preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, staff.getMobileNumber());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, staff.getPosition());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, staff.getUserId());
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
    public Staff getStaffByID(String staffID) {
        return actionOnStaff(staffID).get(0);
    }

    /**
     * @return
     */
    @Override
    public ArrayList<Staff> getStaff() {
        return actionOnStaff(null);
    }


    /**
     * @param userID
     * @return
     */

    private ArrayList<Staff> actionOnStaff(String userID) {

        ArrayList<Staff> userList = new ArrayList<>();
        try {
            connection = DBConnectionUtil.getDBConnection();
            if (userID != null && !userID.isEmpty()) {

                preparedStatement = connection
                        .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_MEMBER));
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);

            }
            else {
                preparedStatement = connection
                        .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STAFF));
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Staff staff = new Staff();

                staff.setUserId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
                staff.setUserRole(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
                staff.setUserName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
                staff.setUserMail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
                staff.setUserPass(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
                staff.setStaffId(resultSet.getInt(CommonConstants.COLUMN_INDEX_SIX));
                staff.setPosition(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
                staff.setMobileNumber(resultSet.getInt(CommonConstants.COLUMN_INDEX_EIGHT));
                userList.add(staff);
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
    public boolean removeStaff(String userID) {

        boolean status = false;
        if (userID != null && !userID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_STAFF_1));
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
                int i = preparedStatement.executeUpdate();
                if(i != 0){
                    preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_STAFF_2));
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
    public boolean updateStaff(String userID, Staff Staff) {
        boolean res =false;
        if (userID != null && !userID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                preparedStatement = connection
                        .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_STAFF));

                preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, Staff.getUserName());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, Staff.getUserMail());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, Staff.getUserPass());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, Staff.getPosition());
                preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, Staff.getMobileNumber());
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
