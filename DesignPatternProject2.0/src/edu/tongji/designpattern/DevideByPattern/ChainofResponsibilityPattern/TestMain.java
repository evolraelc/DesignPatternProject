package edu.tongji.designpattern.DevideByPattern.ChainofResponsibilityPattern;

import edu.tongji.designpattern.CommonClass.Employee.Manager;
import edu.tongji.designpattern.CommonClass.Employee.Waiter;
import edu.tongji.designpattern.DevideByPattern.AdapterPattern.RealDiscount;

/**
 * @description:
 * @autho: Cheng
 * @created: 2019-11-05-13-28
 **/
public class TestMain {


    public static void main(String[] args) {

        Manager manager = new Manager();
        Waiter waiter = new Waiter();

        Complaint complaint = new Complaint("1", manager, waiter);
        complaint.setCurHanlder();
        complaint.getEmployee().settleComplaint();

        Complaint complaint1 = new Complaint("3", manager, waiter);
        complaint1.setCurHanlder();
        complaint1.settleProblem();
    }

}


