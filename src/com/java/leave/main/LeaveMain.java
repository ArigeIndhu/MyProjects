package com.java.leave.main;


import com.java.employee.exception.EmployeeException;
import com.java.leave.bal.LeaveBal;
import com.java.leave.exception.LeaveException;
import com.java.leave.model.Leave;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class LeaveMain {

    static LeaveBal leaveBal;
    static{
        leaveBal = new LeaveBal();
    }

    public static void getAllLeavesMain(){
        List<Leave> leaveList = leaveBal.getAllLeavesBal();
        leaveList.forEach(System.out::println);
    }

    public static void addLeaveMain() throws LeaveException, ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Leave leave = new Leave();

        System.out.println("Enter Leave ID:   ");
        leave.setLeaveId(sc.nextInt());
        System.out.println("Enter Employee ID:   ");
        leave.setEmpId(sc.nextInt());
        System.out.println("Enter Leave Reason:   ");
        leave.setLeaveReason(sc.next());
        System.out.println("Enter Leave Start Date (dd-MM-yyyy): ");
        java.util.Date startDate = sdf.parse(sc.next());
        leave.setLeaveStartDate(startDate);
        System.out.println("Enter Leave End Date (dd-MM-yyyy): ");
        java.util.Date endDate = sdf.parse(sc.next());
        leave.setLeaveEndDate(endDate);

        long diff = endDate.getTime() - startDate.getTime();
        long noOfDays = diff / (1000 * 60 * 60 * 24);
        leave.setNoOfDays((int) noOfDays);
        leave.setAppliedOn(new Date(new java.util.Date().getTime()));

        System.out.println(leaveBal.addLeaveBal(leave));

    }

    public static void getLeaveByIdMain()  {
        int leave_id;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Leave ID:   ");
        leave_id = sc.nextInt();
        Leave LeaveFound = leaveBal.getLeaveById(leave_id);
        if(LeaveFound!=null){
            System.out.println(LeaveFound);
        } else {
            System.out.println("Leave Not Found...");
        }
    }

    public static void updateLeaveMain() throws LeaveException {
        Scanner sc = new Scanner(System.in);
        Leave leave = new Leave();
        System.out.println("Enter Leave ID:   ");
        leave.setLeaveId(sc.nextInt());
        System.out.println("Enter Employee ID:   ");
        leave.setEmpId(sc.nextInt());
        System.out.println("Enter Leave Reason:   ");
        leave.setLeaveReason(sc.next());
        System.out.println("Enter Leave Start Date:   ");
        Date startDate = new Date(new java.util.Date().parse(sc.next()));
        leave.setLeaveStartDate(startDate);
        System.out.println("Enter Leave End Date:   ");
        Date endDate = new Date(new java.util.Date().parse(sc.next()));
        leave.setLeaveEndDate(endDate);
        leave.setNoOfDays(leave.getLeaveEndDate().compareTo(leave.getLeaveStartDate()));
        leave.setAppliedOn(new Date(new java.util.Date().getTime()));

        System.out.println(leaveBal.updateLeaveBal(leave));
    }

    public static void deleteLeaveMain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Leave ID:   ");
        int leave_id = sc.nextInt();
        System.out.println(leaveBal.deleteLeaveBal(leave_id));
    }

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("O P T I O N S");
            System.out.println("1. Add Leave");
            System.out.println("2. Show ALl Leaves");
            System.out.println("3. Search Leave");
            System.out.println("4. Delete Leave");
            System.out.println("5. Update Leave");
            System.out.println("6. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1 :
                    try {
                        addLeaveMain();
                    } catch (LeaveException | ParseException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2 :
                    getAllLeavesMain();
                    break;
                case 3 :
                    getLeaveByIdMain();
                    break;
                case 4 :
                    deleteLeaveMain();
                    break;
                case 5 :
                    try {
                        updateLeaveMain();
                    } catch (LeaveException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 6 :
                    System.exit(0);
            }
        } while(choice !=6);
    }

}