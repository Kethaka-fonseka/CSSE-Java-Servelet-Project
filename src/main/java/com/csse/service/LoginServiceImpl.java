package com.csse.service;

import com.csse.model.LoginBean;
import com.csse.util.CommonConstants;
import com.csse.util.DBConnectionUtil;
import com.csse.util.QueryUtil;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginServiceImpl implements ILoginService{

	public static final Logger log = Logger.getLogger(LoginServiceImpl.class.getName());

	public boolean validate(LoginBean loginBean)  {

		boolean status = false;


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
			status = resultSet.next();

		} catch (SQLException | SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, e.getMessage());
		}

		return status;
	}

	
	
}
