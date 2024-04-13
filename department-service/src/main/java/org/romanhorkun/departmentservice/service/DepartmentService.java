package org.romanhorkun.departmentservice.service;

import org.romanhorkun.departmentservice.dto.DepartmentDTO;
import org.romanhorkun.departmentservice.dto.ParcelDTO;

import java.util.Set;

public interface DepartmentService {

    DepartmentDTO getDepartmentById(int id);

    Set<DepartmentDTO> getAllDepartments();

    void addParcelToDepartment(int departmentId, ParcelDTO parcelDTO);

    void pickupParcel(int departmentId, String parcelId);

    Set<String> deliverParcel(int departmentId, int amount);

}
