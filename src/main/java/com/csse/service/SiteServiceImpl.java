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
import com.csse.model.Site;
import org.xml.sax.SAXException;
import com.csse.util.CommonConstants;
import com.csse.util.DBConnectionUtil;
import com.csse.util.QueryUtil;
import java.util.logging.Logger;

public class SiteServiceImpl implements SiteService {

    private static Connection connection;
    private PreparedStatement preparedStatement;

    /**
     * Initialise logger
     */
    public static final Logger log = Logger.getLogger(SiteServiceImpl.class.getName());

    @Override
    public boolean addSite(Site site) {
        try {
            // get database connection from DBConnection class in DBConnection package
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_SITES));

            connection.setAutoCommit(false);

            // assign values

            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, site.getSiteName());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, site.getSiteLocation());
            preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, site.getSiteBudget());
            preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, site.getMinBudget());
//            preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, 1);
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

    @Override
    public Site editSite(String siteId) throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException {

        ArrayList<Site> sites = new ArrayList<>();

        try {
            // get database connection from DBConnection class in DBConnection package
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SITE));

            connection.setAutoCommit(false);
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, siteId);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {

                Site site = new Site();

                site.setSiteId(result.getString(CommonConstants.COLUMN_INDEX_ONE));
                site.setSiteName(result.getString(CommonConstants.COLUMN_INDEX_TWO));
                site.setSiteLocation(result.getString(CommonConstants.COLUMN_INDEX_THREE));
                site.setSiteBudget(result.getInt(CommonConstants.COLUMN_INDEX_FOUR));
                site.setMinBudget(result.getInt(CommonConstants.COLUMN_INDEX_FIVE));


                sites.add(site);
            }
            System.out.println("RUN PROPERLY");

        } catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
            log.log(Level.SEVERE, e.getMessage());

            System.out.println("ERROR HERE RUN");
        } finally {
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
        return sites.get(0);
    }

    @Override
    public boolean updateSite(Site site) {
        try {
            // get database connection from DBConnection class in DBConnection package
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_SITE));

            connection.setAutoCommit(false);

            // assign values
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, site.getSiteName());
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, site.getSiteLocation());
            preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_THREE, site.getSiteBudget());
            preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FOUR, site.getMinBudget());
            preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, Integer.parseInt(site.getSiteId()));
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

    @Override
    public int deleteSite(Site site) {
        int result;

        try {
            // get database connection from DBConnection class in DBConnection package
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_SITE));

            connection.setAutoCommit(false);

            // assign values
            preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, site.getSiteId());
            result = preparedStatement.executeUpdate();
            connection.commit();

            return result;

        } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
            log.log(Level.SEVERE, e.getMessage());
            return 0;
        } finally {
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

    @Override
    public List<Site> getSite() throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException {

        ArrayList<Site> sites = new ArrayList<>();

        try {
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection
                    .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_GET_SITE));

            connection.setAutoCommit(false);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Site site = new Site();

                site.setSiteId(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
                site.setSiteName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
                site.setSiteLocation(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
                site.setSiteBudget(rs.getInt(CommonConstants.COLUMN_INDEX_FOUR));
                site.setMinBudget(rs.getInt(CommonConstants.COLUMN_INDEX_FIVE));

                sites.add(site);
            }
        } catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
            log.log(Level.SEVERE, e.getMessage());
        } finally {
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
        return sites;
    }
}


