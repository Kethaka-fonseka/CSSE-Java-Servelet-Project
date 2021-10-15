package com.csse.service;

import com.csse.model.Requisition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequisitionServiceimplTest {

    @Test
    void addRequisition() {
        Requisition requisition = new Requisition();

        requisition.setRequisitionType("Type001");
        requisition.setRequestedBy("Site-Owner");
        requisition.setSiteLocation("Malabe");
        requisition.setItemName("Mettle");
        requisition.setItemQty(100);
        requisition.setRequestedPrice(10000);
        requisition.setTotalPrice(20000);

        IRequisitionService requisitionService=new RequisitionServiceimpl();

        boolean actual_result=  requisitionService.addRequisition(requisition);

       assertEquals(true,actual_result);

    }

    @Test
    void checkApprovable() {

        IRequisitionService requisitionService=new RequisitionServiceimpl();

        boolean actual_result=  requisitionService.checkApprovable("CONSTRUCTION", 10000);
        assertEquals(false,actual_result);

    }

    @Test
    void removeItem() {
        IRequisitionService requisitionService=new RequisitionServiceimpl();
        int actual_result=  requisitionService.removeItem(003);
        assertEquals(1,actual_result);

    }

    @Test
    void updateRequisition() {

        Requisition requisition = new Requisition();

        requisition.setRequisitionType("Type003");
        requisition.setRequestedBy("Site-Owner");
        requisition.setSiteLocation("Colombo-07");
        requisition.setItemName("Sand");
        requisition.setItemQty(5);
        requisition.setRequestedPrice(10000);
        requisition.setTotalPrice(20000);

        IRequisitionService requisitionService=new RequisitionServiceimpl();

        boolean actual_result=  requisitionService.updateRequisition(requisition);

        assertEquals(true,actual_result);

    }
}