package com.csse.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.csse.model.Requisition;

	public interface IRequisitionService {
		/** Initialize logger */
		public static final Logger log = Logger.getLogger(IRequisitionService.class.getName());
		
		

		/**
		 * Add requisition for requisition table
		 * @param requisition
		 */
		public boolean addRequisition(Requisition requisition);


		boolean checkApprovable(String siteName, float totalPrice);

		/**
		 * Get a particular requisition
		 * 
		 * @param requisitionID
		 * @return Requisition
		 */
		public Requisition getRequisitionByID(int requisitionID);

		/**
		 * Get requisition list
		 *
		 *
		 * @return Requisition
		 */
		public ArrayList<Requisition> getAllRequisitions();

		/**
		 * Remove existing requisition
		 *
		 * @param requisitionNo
		 */
		public int removeItem(int requisitionNo);


        boolean updateRequisition(Requisition requisition);
    }
