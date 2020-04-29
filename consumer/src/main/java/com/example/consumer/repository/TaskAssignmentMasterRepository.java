package com.example.consumer.repository;

import com.example.consumer.dataobject.TaskAssignmentMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskAssignmentMasterRepository  extends JpaRepository<TaskAssignmentMaster,String> {

}
