package com.java.leave.bal;


import com.java.leave.dao.LeaveDao;
import com.java.leave.dao.LeaveDaoImpl;
import com.java.leave.exception.LeaveException;
import com.java.leave.model.Leave;

import java.sql.Date;
import java.util.List;

public class LeaveBal {

    static StringBuilder sb;
    static LeaveDao leaveDao;

    static {
        sb = new StringBuilder();
        leaveDao = new LeaveDaoImpl();
    }

    public List<Leave> getAllLeavesBal() {
        return leaveDao.getAllLeavesDao();
    }

    public String addLeaveBal(Leave leave) throws LeaveException {
        if(validateLeave(leave) == true){
            return leaveDao.addLeaveDao(leave);
        }
        throw new LeaveException();
    }

    public Leave getLeaveById(int leave_id) {
        return leaveDao.getLeaveByIdDao(leave_id);
    }

    public String updateLeaveBal(Leave leave) throws LeaveException {
        if(validateLeave(leave)== true) {
            return leaveDao.updateLeaveDao(leave);
        }
        throw new LeaveException(sb.toString());
    }

    public String deleteLeaveBal(int leave_id) {
        return leaveDao.deleteLeaveDao(leave_id);
    }

    public boolean validateLeave(Leave leave) {
        boolean isValid = true;
        java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
        if(leave.getLeaveEndDate().compareTo(leave.getLeaveStartDate()) < 0 ){
            isValid = false;
            sb.append("End Date must be after Start Date...");
        }
        if (leave.getLeaveEndDate().compareTo(now) < 0 ){
            isValid = false;
            sb.append("End Date must be greater than yesterday...");
        }
        if (leave.getLeaveStartDate().compareTo(now) < 0 ){
            isValid = false;
            sb.append("Start Date must be before yesterday...");
        }
        return isValid;
    }
}
