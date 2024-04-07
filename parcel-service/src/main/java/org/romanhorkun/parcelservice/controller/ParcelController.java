package org.romanhorkun.parcelservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.romanhorkun.parcelservice.domain.dto.parcel.ParcelDTO;
import org.romanhorkun.parcelservice.domain.dto.parcel.ParcelCreateFormDTO;
import org.romanhorkun.parcelservice.service.ParcelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parcel")
public class ParcelController {

    private final ParcelService parcelService;

    @GetMapping("/{id}")
    public ParcelDTO getById(@PathVariable String id){
        final ParcelDTO byId = parcelService.getById(id);

        if (byId == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return parcelService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParcelDTO create(@Valid @RequestBody ParcelCreateFormDTO parcelDTO){
        return parcelService.create(parcelDTO);
    }

    //TODO add the ability to update, but there will be conditions

}
