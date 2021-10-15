package com.csse.model;

import java.util.ArrayList;

public class Requisition {

	private int requisitionNo;
	private String requisitionType;
	private String requestedBy;
	private String siteLocation;
	private String itemName;
	private int  itemQty;
	private float requestedPrice;
	private String status;
	private float totalPrice;

	public int getRequisitionNo() {
		return requisitionNo;
	}

	public void setRequisitionNo(int requisitionNo) {
		this.requisitionNo = requisitionNo;
	}

	public String getRequisitionType() {
		return requisitionType;
	}

	public void setRequisitionType(String requisitionType) {
		this.requisitionType = requisitionType;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getSiteLocation() {
		return siteLocation;
	}

	public void setSiteLocation(String siteLocation) {
		this.siteLocation = siteLocation;

	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public float getRequestedPrice() {
		return requestedPrice;
	}

	public void setRequestedPrice(float requestedPrice) {
		this.requestedPrice = requestedPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Requisition{" +
				"requisitionNo=" + requisitionNo +
				", requisitionType='" + requisitionType + '\'' +
				", requestedBy='" + requestedBy + '\'' +
				", siteLocation='" + siteLocation + '\'' +
				", itemName='" + itemName + '\'' +
				", itemQty=" + itemQty +
				", requestedPrice=" + requestedPrice +
				", status='" + status + '\'' +
				", totalPrice=" + totalPrice +
				'}';
	}
}


