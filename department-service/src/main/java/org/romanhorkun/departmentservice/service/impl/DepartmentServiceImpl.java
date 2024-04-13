package org.romanhorkun.departmentservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.romanhorkun.departmentservice.dao.DepartmentDao;
import org.romanhorkun.departmentservice.dto.DepartmentDTO;
import org.romanhorkun.departmentservice.dto.ParcelDTO;
import org.romanhorkun.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao;

    @Override
    public DepartmentDTO getDepartmentById(int id){
        return departmentDao.getDepartmentById(id);
    }

    @Override
    public Set<DepartmentDTO> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    @Override
    public void addParcelToDepartment(int departmentId, ParcelDTO parcelDTO){
        if (departmentId == parcelDTO.getFrom().getId()) {
            departmentDao.addParcelToDeliver(departmentId, parcelDTO.getId());
        }else{
            departmentDao.addParcelToReady(departmentId, parcelDTO.getId());

            //TODO update parcel status using Kafka

            //TODO send notification
        }
    }

    @Override
    public void pickupParcel(int departmentId, String parcelId) {
        departmentDao.pickupParcel(departmentId, parcelId);

        //TODO update parcel status using Kafka
    }

    @Override
    public Set<String> deliverParcel(int departmentId, int amount) {
        return departmentDao.pickupParcelsForDelivery(departmentId, amount);

        //TODO update parcel status using Kafka
    }
}
