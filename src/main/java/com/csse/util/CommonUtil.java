
package com.csse.util;

import com.csse.service.ILoginService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonUtil {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ILoginService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}



//	public static String generateuIDs(ArrayList<String> arrayList) {
//
//		String id;
//		int next = arrayList.size();
//		next++;
//		id = CommonConstants.USER_ID_PREFIX + next;
//		if (arrayList.contains(id)) {
//			next++;
//			id = CommonConstants.USER_ID_PREFIX + next;
//		}
//		return id;
//	}

}
