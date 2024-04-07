package org.romanhorkun.parcelservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.romanhorkun.parcelservice.dao.ParcelDAO;
import org.romanhorkun.parcelservice.domain.dto.parcel.ParcelDTO;
import org.romanhorkun.parcelservice.domain.dto.parcel.ParcelCreateFormDTO;
import org.romanhorkun.parcelservice.service.ParcelService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    private final ParcelDAO repository;
    private final ModelMapper mapper;

    @Override
    public ParcelDTO getById(String id) {
        return repository.get(id);
    }

    @Override
    public ParcelDTO create(ParcelCreateFormDTO parcelCreateFormDTO) {
        final ParcelDTO parcelDTO = mapper.map(parcelCreateFormDTO, ParcelDTO.class);
        parcelDTO.setStatus(ParcelDTO.Status.ACCEPTED);

        final ParcelDTO createdParcelDTO = repository.create(parcelDTO);

        //TODO add to department using Kafka

        return createdParcelDTO;
    }

}
