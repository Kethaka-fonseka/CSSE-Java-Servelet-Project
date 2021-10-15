package com.csse.service;

import com.csse.model.Manager;
import com.csse.model.Requisition;
import com.csse.model.Site;
import com.csse.util.CommonConstants;
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

public class RequisitionServiceimpl implements IRequisitionService {

    /** Initialize logger */
    public static final Logger log = Logger.getLogger(RequisitionServiceimpl.class.getName());

    private static Connection connection;

    private static PreparedStatement  preparedStatement;


    @Override
    public void addRequisition(Requisition requisition) {
        try {
            connection = DBConnectionUtil.getDBConnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_REQUISITION));
            connection.setAutoCommit(false);

            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,requisition.getRequisitionType());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, requisition.getRequestedBy());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, requisition.getSiteLocation());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, requisition.getItemName());
            preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, requisition.getItemQty());
            preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_SIX, requisition.getRequestedPrice());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, requisition.getStatus());
            preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_EIGHT, requisition.getTotalPrice());

            preparedStatement.execute();
            connection.commit();

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

    }

    @Override
    public boolean checkApprovable(String siteName, float totalPrice) {
        boolean reply = false;
        if (totalPrice != 0 && siteName != null) {
            /*
             * Site data will be retrieved from query.xml
             */
            try {
                connection = DBConnectionUtil.getDBConnection();
                preparedStatement = connection
                        .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SITE_BY_NAME));
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, siteName);
                ResultSet resultSet = preparedStatement.executeQuery();
                while((resultSet.next())) {
                    float minBudget = resultSet.getFloat(CommonConstants.COLUMN_INDEX_ONE);
                    System.out.println(minBudget);
                    if (minBudget > 0) {
                        if (totalPrice < minBudget) {
                            reply = true;
                        }
                    } else {
                        System.out.println("No Budget");
                    }
                }
            } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
        return reply;
    }

    @Override
    public Requisition getRequisitionByID(int requisitionNo) {
        return actionOnRequisition(requisitionNo).get(0);
    }

    @Override
    public ArrayList<Requisition> getAllRequisitions() {
        return actionOnRequisition(0);
    }

    @Override
    public void removeItem(int requisitionNo) {

        // Before deleting check whether requisitionNo is available
        if (requisitionNo != 0) {
            /*
             * Remove requisition query will be retrieved from Query.xml
             */
            try {
                connection = DBConnectionUtil.getDBConnection();
                preparedStatement = connection
                        .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_REQUISITION));
                preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, requisitionNo);
                preparedStatement.executeUpdate();
            } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
    }

    private ArrayList<Requisition> actionOnRequisition(int requisitionNo) {

        ArrayList<Requisition> requisitionsList = new ArrayList<Requisition>();
        try {
            connection = DBConnectionUtil.getDBConnection();
            if (requisitionNo != 0) {

                preparedStatement = connection
                        .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_REQUISITION));
                preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, requisitionNo);
            }
            else {
                preparedStatement = connection
                        .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_REQUISITIONS));
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
               Requisition requisition = new Requisition();

                requisition.setRequisitionNo(resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE));
                requisition.setRequisitionType(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
                requisition.setRequestedBy(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
                requisition.setSiteLocation(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
                requisition.setItemName(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
                requisition.setItemQty(resultSet.getInt(CommonConstants.COLUMN_INDEX_SIX));
                requisition.setRequestedPrice(resultSet.getFloat(CommonConstants.COLUMN_INDEX_SEVEN));
                requisition.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
                requisition.setTotalPrice(resultSet.getFloat(CommonConstants.COLUMN_INDEX_NINE));

               requisitionsList.add(requisition);
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
        return requisitionsList;
    }
    @Override
    public boolean updateRequisition(Requisition requisition) {
        boolean res =false;

            try {
                connection = DBConnectionUtil.getDBConnection();
                preparedStatement = connection
                        .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_REQUISITION));

                preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, requisition.getRequisitionType());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, requisition.getItemName());
                preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, requisition.getItemQty());
                preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_FOUR, requisition.getRequestedPrice());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, requisition.getStatus());
                preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_SIX, requisition.getTotalPrice());
                preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SEVEN, requisition.getRequisitionNo());
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

        return res;
    }

    @Override
    public boolean approvalRequisition(Requisition requisition) {
        boolean reply =false;

        try {
            connection = DBConnectionUtil.getDBConnection();
            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_APPROVAL));

            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, requisition.getStatus());
            preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, requisition.getRequisitionNo());

            int i  =preparedStatement.executeUpdate();
            if(i!=0){
                reply = true;
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

        return reply;
    }


}
