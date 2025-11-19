package com.java.leave.dao;

import com.java.leave.model.Leave;

import java.util.List;

public interface LeaveDao {
    String addLeaveDao(Leave leave);
    List<Leave> getAllLeavesDao();
    String updateLeaveDao(Leave leaveUpdate);
    String deleteLeaveDao(int leave_id);
    Leave getLeaveByIdDao(int leave_id);
}
