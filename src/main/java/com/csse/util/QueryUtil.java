package com.csse.util;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Element;

public class QueryUtil extends CommonUtil {
	/**
	 * This method read the ItemQuery.xml file and retrieve the query by
	 * query id.
	 * 
	 * @param id
	 *            QueryID to retrieve elements
	 * 
	 * @return String formatted query will be returned as output
	 * 
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws IOException
	 *             - This class is the general class of exceptions produced by
	 *             failed or interrupted I/O operations.
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning.
	 *
	 */
	public static String queryByID(String id) throws SAXException, IOException, ParserConfigurationException {

		NodeList nodeList;
		Element element = null;

		/*
		 * Read the Query.xml file and read each query node into node
		 * list. It refers tag name query
		 */



		/* stream = QueryUtil.class.getClassLoader().getResourceAsStream("/Query.xml");
		 * System.out.println(stream != null);
		 * DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance() ;
		 * DocumentBuilder builder = factory.newDocumentBuilder();
		 * Document document = builder.parse(stream);*/


		InputStream stream = QueryUtil.class.getResourceAsStream(CommonConstants.QUERY_XML);
	    /*Prints boolean statement which varies with availability of the Query.xml*/
		System.out.println(stream != null);

		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(stream).getElementsByTagName(CommonConstants.TAG_NAME);
		/*
		 * Extract the node from node list using query id query id is taken from
		 * query node attribute
		 */
		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);
			if (element.getAttribute(CommonConstants.ATTRIB_ID).equals(id))
				break;
		}
		assert element != null;
		return element.getTextContent().trim();
	}
}
