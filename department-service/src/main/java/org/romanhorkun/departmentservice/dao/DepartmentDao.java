package org.romanhorkun.departmentservice.dao;

import org.romanhorkun.departmentservice.dto.DepartmentDTO;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class DepartmentDao {

    private final Map<Integer, DepartmentDTO> departments;
    {
        departments = Stream.of(
                        new DepartmentDTO(1, "Kyiv"),
                        new DepartmentDTO(2, "Kharkiv"),
                        new DepartmentDTO(3, "Poltava"),
                        new DepartmentDTO(4, "Dnipro"),
                        new DepartmentDTO(5, "Kherson"))
                .collect(Collectors.toMap(DepartmentDTO::getId, Function.identity()));
    }

    private final Map<Integer, Queue<String>> deliverParcelsInDepartments = new HashMap<>();    //FIFO
    private final Map<Integer, Set<String>> readyParcelsInDepartments = new HashMap<>();
    {
        for(Integer departmentId: departments.keySet()){
            deliverParcelsInDepartments.put(departmentId, new LinkedList<>());
            readyParcelsInDepartments.put(departmentId, new HashSet<>());
        }
    }

    public Set<DepartmentDTO> getAllDepartments(){
        return new HashSet<>(departments.values());
    }

    public DepartmentDTO getDepartmentById(int departmentId){
        return departments.get(departmentId);
    }

    public void addParcelToDeliver(int departmentId, String parcelId){
        deliverParcelsInDepartments.get(departmentId).offer(parcelId);
    }

    public void addParcelToReady(int departmentId, String parcelId){
        readyParcelsInDepartments.get(departmentId).add(parcelId);
    }

    public void pickupParcel(int departmentId, String parcelId){
        readyParcelsInDepartments.get(departmentId).remove(parcelId);
    }

    public Set<String> pickupParcelsForDelivery(int departmentId, int amount){
        final Set<String> parcels = new HashSet<>();

        final Queue<String> parcelsInDepartment = deliverParcelsInDepartments.get(departmentId);
        for(int i=0; i<amount; i++){
            if(parcelsInDepartment.peek() != null)
                parcels.add(parcelsInDepartment.poll());
        }

        return parcels;
    }

}
