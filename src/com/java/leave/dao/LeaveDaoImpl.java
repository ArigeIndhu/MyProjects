package com.java.leave.dao;


import com.java.leave.model.Leave;

import java.util.ArrayList;
import java.util.List;

public class LeaveDaoImpl implements LeaveDao {

    static List<Leave> leaveList;

    static {
        leaveList = new ArrayList<>();
    }

    @Override
    public String addLeaveDao(Leave leave) {
        leaveList.add(leave);
        return "Leave with LeaveID:"+ leave.getLeaveId()+ " Added Successfully... ";
    }

    @Override
    public List<Leave> getAllLeavesDao() {
        return leaveList;
    }

    @Override
    public String updateLeaveDao(Leave leaveUpdate) {
        Leave leaveFound = getLeaveByIdDao(leaveUpdate.getLeaveId());
        if(leaveFound != null) {
            leaveFound.setLeaveEndDate(leaveUpdate.getLeaveEndDate());
            leaveFound.setLeaveStartDate(leaveUpdate.getLeaveStartDate());
            leaveFound.setLeaveReason(leaveUpdate.getLeaveReason());
            leaveFound.setAppliedOn(leaveUpdate.getAppliedOn());
            leaveFound.setEmpId(leaveUpdate.getEmpId());
            leaveFound.setNoOfDays(leaveUpdate.getNoOfDays());
            return "Leave record Updated Successfully... ";
        }
        return "Leave Record Not Found... ";
    }

    @Override
    public String deleteLeaveDao(int leave_id) {
        Leave leaveFound = getLeaveByIdDao(leave_id);
        if(leaveFound != null) {
            leaveList.remove(leaveFound);
            return "Leave Deleted Successfully... ";
        }

        return "Leave Not Found... ";
    }

    @Override
    public Leave getLeaveByIdDao(int leave_id) {
        Leave leaveFound = leaveList.stream().filter(x -> x.getLeaveId()== leave_id).findFirst().orElse(null);
        return leaveFound;
    }
}
