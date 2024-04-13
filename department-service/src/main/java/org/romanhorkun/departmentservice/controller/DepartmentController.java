package org.romanhorkun.departmentservice.controller;

import lombok.RequiredArgsConstructor;
import org.romanhorkun.departmentservice.dto.DepartmentDTO;
import org.romanhorkun.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable int id){
        final DepartmentDTO byId = departmentService.getDepartmentById(id);

        if (byId == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return byId;
    }

    @GetMapping("/all")
    public Set<DepartmentDTO> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @PutMapping("/{departmentId}/parcel/{parcelId}/pickup")
    public void pickupParcel(@PathVariable int departmentId, @PathVariable String parcelId){
        departmentService.pickupParcel(departmentId, parcelId);
    }

    @PutMapping("/{departmentId}/parcel/deliver")
    public Set<String> deliverParcel(@PathVariable int departmentId, @RequestParam("amount") int amount){   //TODO add transaction
        return departmentService.deliverParcel(departmentId, amount);
    }

}
