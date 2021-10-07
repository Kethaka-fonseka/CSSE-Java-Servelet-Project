package com.csse.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import com.csse.model.Supplier;
import com.csse.model.User;
import com.csse.util.CommonConstants;
import com.csse.util.CommonUtil;
import com.csse.util.DBConnectionUtil;
import com.csse.util.QueryUtil;
import org.xml.sax.SAXException;

public class RegisterServiceImpl implements IRegisterService {

	public static final Logger log = Logger.getLogger(RegisterServiceImpl.class.getName());
	private static Connection connection;
	private PreparedStatement preparedStatement;
	/*
	static{
		create table or drop if exist
		createUserTable();
	}
	*/


/* public static void createUserTable() {

 		try {
 			connection = DBConnectionUtil.getDBConnection();
 			statement = connection.createStatement();
 			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE3));

 		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
 			log.log(Level.SEVERE, e.getMessage());
 		}
 	}*/

	/**
	 * @param user
	 * @param supplier
	 * @return res
	 */
	@Override
	public boolean addSupplier(User user, Supplier supplier) {
        boolean res = false;

		String userID = CommonUtil.generateUID(getUserIDs());
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_USER));
			
			connection.setAutoCommit(false);

			user.setUserId(userID);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, user.getUserId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, user.getUserRole());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, user.getUserName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, user.getUserMail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, user.getUserPass());
			boolean result = preparedStatement.execute();
			connection.commit();
			if(!result){
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_SUP));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, supplier.getCompanyName());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, supplier.getContactNumber());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, user.getUserId());
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
	public boolean addStaff(User user, Supplier supplier) {
		boolean res = false;

		String userID = CommonUtil.generateUID(getUserIDs());
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_USER));

			connection.setAutoCommit(false);

			user.setUserId(userID);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, user.getUserId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, user.getUserRole());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, user.getUserName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, user.getUserMail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, user.getUserPass());
			boolean result = preparedStatement.execute();
			connection.commit();
			if(!result){
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_STAFF));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, supplier.getCompanyName());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, supplier.getContactNumber());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, user.getUserId());
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

/*
	public void removeUser(String userID) {
		if (userID != null && !userID.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_USER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				*/
/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 *//*

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
*/



	/**
	 * @param supplierID
	 * @return
	 */
	@Override
	public Supplier getSupplierByID(String supplierID) {
		return actionOnSupplier(supplierID).get(0);
	}

	/**
	 * @return
	 */
	@Override
	public ArrayList<Supplier> getSuppliers() {
		return actionOnSupplier(null);
	}


	/**
	 * @param userID
	 * @return
	 */
	private ArrayList<Supplier> actionOnSupplier(String userID) {

		ArrayList<Supplier> userList = new ArrayList<>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			if (userID != null && !userID.isEmpty()) {

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SUPPLIER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
			}
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_SUPPLIERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Supplier Supplier = new Supplier();

				Supplier.setUserId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				Supplier.setUserMail(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				Supplier.setUserPass(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				Supplier.setUserName(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				Supplier.setContactNumber(resultSet.getInt(CommonConstants.COLUMN_INDEX_FIVE));
				Supplier.setCompanyName(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				userList.add(Supplier);
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
/*
	@Override
	public Supplier updateUser(String userID, Supplier Supplier) {

		if (userID != null && !userID.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_USER));

				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, Supplier.getuId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, Supplier.getuName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, Supplier.getuMail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, Supplier.getuPass());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, Supplier.getuR_Pass());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, Supplier.getU_type());
				preparedStatement.executeUpdate();

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
		return getUserByID(userID);
	}*/

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


/*

	public String validateUser(Supplier Supplier){

		String resp = null;
		try {
		connection = DBConnectionUtil.getDBConnection();

		preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_VALIDATE_NAME));

		connection.setAutoCommit(false);

		preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, Supplier.getuName());

		ResultSet res = preparedStatement.executeQuery();


		if(res.next()){
			resp = "Taken";
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

		return resp;

	}

*/

/*	@Override
	public Supplier getUserByName(String username) {
		return Detailsgetter(username).get(0);
	}*/
/*
	private ArrayList<Supplier> Detailsgetter(String username) {

		ArrayList<Supplier> Details = new ArrayList<Supplier>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_USERBY_NAME));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, username);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Supplier Supplier = new Supplier();

				Supplier.setuId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				Supplier.setuName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				Supplier.setuMail(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				Supplier.setuPass(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				Supplier.setuR_Pass(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				Supplier.setU_type(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));

				Details.add(Supplier);
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
		return Details;
	}*/


}

