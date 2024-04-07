package org.romanhorkun.parcelservice.dao;

import org.romanhorkun.parcelservice.domain.dto.parcel.ParcelDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class ParcelDAO {

    private final Map<String, ParcelDTO> parcelDTOs = new HashMap<>();

    public ParcelDTO get(String id){
        return parcelDTOs.get(id);
    }

    public ParcelDTO create(ParcelDTO parcelDTO){
        final String generatedId = generateId();
        parcelDTO.setId(generatedId);
        parcelDTOs.put(generatedId, parcelDTO);

        return parcelDTO;
    }

    public void update(ParcelDTO parcelDTO){
        parcelDTOs.put(parcelDTO.getId(), parcelDTO);
    }

    private String generateId(){
        String generatedId = UUID.randomUUID().toString();
        while (parcelDTOs.containsKey(generatedId)) {
            generatedId = UUID.randomUUID().toString();
        }

        return generatedId;
    }

}
