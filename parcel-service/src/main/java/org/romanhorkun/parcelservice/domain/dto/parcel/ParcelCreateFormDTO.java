package org.romanhorkun.parcelservice.domain.dto.parcel;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.romanhorkun.parcelservice.domain.dto.DepartmentDTO;
import org.romanhorkun.parcelservice.domain.dto.UserDTO;

@Data
@NoArgsConstructor
public class ParcelCreateFormDTO {

    private String description;
    @Valid
    private DepartmentDTO from;
    @Valid
    private DepartmentDTO to;
    @Valid
    private UserDTO recipient;
    @Valid
    private UserDTO sender;

}
