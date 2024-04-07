package org.romanhorkun.parcelservice.service;

import org.romanhorkun.parcelservice.domain.dto.parcel.ParcelDTO;
import org.romanhorkun.parcelservice.domain.dto.parcel.ParcelCreateFormDTO;

public interface ParcelService {

    ParcelDTO getById(String id);

    ParcelDTO create(ParcelCreateFormDTO parcelDTO);

}
