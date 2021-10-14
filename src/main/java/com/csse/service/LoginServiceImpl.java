package com.csse.service;
import com.csse.model.LoginBean;
import com.csse.model.Staff;
import com.csse.model.Supplier;
import com.csse.model.User;
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

public class LoginServiceImpl implements ILoginService {

	public static final Logger log = Logger.getLogger(LoginServiceImpl.class.getName());
	private static Connection connection;
	private PreparedStatement preparedStatement;
	/**
	 * @param loginBean
	 * @return state
	 */
	public boolean validate(LoginBean loginBean)  {

		boolean state = false;


		try {
			Connection connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in Query.xml file and use
			 * insert_item key to extract value of it
			 */

			PreparedStatement preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_USER));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, loginBean.getUserEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, loginBean.getUserPass());
			ResultSet resultSet = preparedStatement.executeQuery();
			state = resultSet.next();

		} catch (SQLException | ParserConfigurationException | IOException | SAXException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}

		return state;
	}




	@Override
	public User getUserByEmail(String email) {
		return DetailsGetter(email).get(0);
	}

	private ArrayList<User> DetailsGetter(String email) {

		ArrayList<User> Details = new ArrayList<>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_USER_BY_MAIL));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, email);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User();

				user.setUserId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				user.setUserRole(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				user.setUserName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				user.setUserMail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				user.setUserPass(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));

				Details.add(user);
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


	}
}
