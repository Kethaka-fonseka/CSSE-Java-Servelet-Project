package com.csse.util;

import com.csse.model.Requisition;

public class CommonConstants {

	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "/Query.xml";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "/config.properties";

	/** Constant for query tag in Query.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in Query.xml */
	public static final String ATTRIB_ID = "id";

	/** Constant for item id prefix */
	public static final String USER_ID_PREFIX = "U";

	/** Constant for comma */
	public static final String COMMA = ",";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for query id of drop_table in ItemQuery.xml */
	public static final String QUERY_ID_DROP_TABLE = "drop_table";

	/** Constant for query id of create_table in Query.xml */
	public static final String QUERY_ID_CREATE_TABLE2 = "create_category_table";
  
/** Constant for query id of login in Query.xml */
	public static final String QUERY_ID_GET_USER = "log_user";

/** Constant for query id of login in Query.xml */
	public static final String QUERY_ID_GET_USER_BY_MAIL = "user_by_mail";

	/** Constant for query id of insert user in Query.xml */
	public static final String QUERY_ID_INSERT_USER = "insert_user";

	/** Constant for query id of insert supplier in Query.xml */
	public static final String QUERY_ID_INSERT_SUP = "insert_supplier";

	/** Constant for query id of get user ids in Query.xml */
	public static final String QUERY_ID_GET_USER_IDS = "user_ids";

	/** Constant for query id of get user ids in Query.xml */
	public static final String QUERY_ID_GET_SUPPLIER = "get_supplier";

/** Constant for query id of get user ids in Query.xml */
	public static final String QUERY_ID_ALL_SUPPLIERS = "get_suppliers";

	/** Constant for query id of delete a Supplier in Query.xml */
	public static final String QUERY_ID_REMOVE_SUPPLIER_1 = "delete_supplier_1";

	/** Constant for query id of delete a Supplier in Query.xml */
	public static final String QUERY_ID_REMOVE_SUPPLIER_2 = "delete_supplier_2";

/** Constant for query id of delete a Supplier in Query.xml */
	public static final String QUERY_ID_UPDATE_SUPPLIER = "update_supplier";



	/*STAFF*/
	/** Constant for query id of insert supplier in Query.xml */
	public static final String QUERY_ID_INSERT_STAFF = "insert_staff";

	/** Constant for query id of insert supplier in Query.xml */
	public static final String QUERY_ID_GET_STAFF = "get_staff";

   /** Constant for query id of insert supplier in Query.xml */
	public static final String QUERY_ID_GET_MEMBER = "get_member";

	/** Constant for query id of delete a Supplier in Query.xml */
	public static final String QUERY_ID_REMOVE_STAFF_1 = "delete_staff_1";

	/** Constant for query id of delete a Supplier in Query.xml */
	public static final String QUERY_ID_REMOVE_STAFF_2 = "delete_staff_2";

	/** Constant for query id of delete a Supplier in Query.xml */
	public static final String QUERY_ID_UPDATE_STAFF = "update_staff";


	/*SITE MANAGER*/
	/** Constant for query id of insert supplier in Query.xml */
	public static final String QUERY_ID_INSERT_MANAGER = "insert_manager";

	/** Constant for query id of insert supplier in Query.xml */
	public static final String QUERY_ID_GET_MANAGERS = "get_managers";

   /** Constant for query id of insert supplier in Query.xml */
	public static final String QUERY_ID_GET_MANAGER = "get_manager";

	/** Constant for query id of delete a Supplier in Query.xml */
	public static final String QUERY_ID_REMOVE_MANAGER_1 = "delete_manager_1";

	/** Constant for query id of delete a Supplier in Query.xml */
	public static final String QUERY_ID_REMOVE_MANAGER_2 = "delete_manager_2";

	/** Constant for query id of delete a Supplier in Query.xml */
	public static final String QUERY_ID_UPDATE_MANAGER = "update_manager";

	/*ITEM*/

	/** Constant for query id of insert items in Query.xml */
	public static final String QUERY_ID_INSERT_ITEMS = "insert_item";

	/** Constant for query id of get an item in Query.xml */
	public static final String QUERY_ID_GET_ITEM = "item_by_id";

	/** Constant for query id of update a item in Query.xml */
	public static final String QUERY_ID_UPDATE_ITEM = "update_item";

	/** Constant for query id of remove a item in Query.xml */
	public static final String QUERY_ID_REMOVE_ITEM = "remove_item";

	/** Constant for query id of get an item in Query.xml */
	public static final String QUERY_GET_ITEM = "item_get";

	/** Constant for item validation */
	public static final String ERROR_MESSAGE = "message";

	/** Constant for item validation Item Name */
	public static final String ERROR_MESSAGE_ITEM_NAME = "Enter Item Name";

	/** Constant for item validation Item Code */
	public static final String ERROR_MESSAGE_ITEM_Code = "Enter Item Code";

	/** Constant for item validation Item Quantity */
	public static final String ERROR_MESSAGE_ITEM_PRICE = "Enter Price";

	/** Constant for item validation Item Price */
	public static final String ERROR_MESSAGE_ITEM_Quantity = "Enter Quantity";

	/*SITE*/

	/** Constant for query id of insert sites in Query.xml */
	public static final String QUERY_ID_INSERT_SITES = "insert_sites";

	/** Constant for query id of get a site in Query.xml */
	public static final String QUERY_ID_GET_SITE = "site_by_id";

	/** Constant for query id of update a site in Query.xml */
	public static final String QUERY_ID_UPDATE_SITE = "update_site";

	/** Constant for query id of remove a site in Query.xml */
	public static final String QUERY_ID_REMOVE_SITE = "remove_site";

	/** Constant for query id of get a site in Query.xml */
	public static final String QUERY_GET_SITE = "site_get";

	/** Constant for item validation Item Name */
	public static final String ERROR_MESSAGE_SITE_NAME = "Enter Site Name";

	/** Constant for item validation Item Location */
	public static final String ERROR_MESSAGE_SITE_Location = "Enter Site Location";

	/** Constant for item validation Item Budget */
	public static final String ERROR_MESSAGE_SITE_Budget = "Enter Site Budget";

	/** Constant for item validation Item Minimum Budget */
	public static final String ERROR_MESSAGE_SITE_MINBudget = "Enter Site Min Budget";


/*	Requisition*/
	/** Constant for query id of add requisition  to requisition table */
	public static final String QUERY_ID_INSERT_REQUISITION="create_requisition_table";

	/** Constant for query id of retrive  requisition by id*/
	public static  final String QUERY_ID_GET_REQUISITION="get_requisition_by_id";

	/** Constant for query id of retrive  all requisitions*/
	public static  final String QUERY_ID_ALL_REQUISITIONS="get_all_requisitions";

	/** Constant for query id delete  exiting requisition from id*/
	public static final String QUERY_ID_REMOVE_REQUISITION="remove_requisition";

	public static final int COLUMN_INDEX_ONE = 1;
	public static final int COLUMN_INDEX_TWO = 2;
	public static final int COLUMN_INDEX_THREE = 3;
	public static final int COLUMN_INDEX_FOUR = 4;
	public static final int COLUMN_INDEX_FIVE = 5;
	public static final int COLUMN_INDEX_SIX = 6;
	public static final int COLUMN_INDEX_SEVEN = 7;
	public static final int COLUMN_INDEX_EIGHT = 8;
	public static final int COLUMN_INDEX_NINE = 9;
	public static final int COLUMN_INDEX_TEN = 10;
	public static final int COLUMN_INDEX_ELEVEN = 11;
	public static final int COLUMN_INDEX_TWELVE = 12;
	public static final int COLUMN_INDEX_THIRTY = 13;



}
