package org.romanhorkun.parcelservice.domain.dto.parcel;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.romanhorkun.parcelservice.domain.dto.DepartmentDTO;
import org.romanhorkun.parcelservice.domain.dto.UserDTO;

@Data
@NoArgsConstructor
@Getter
@Setter
public class ParcelDTO {

    private String id;
    private DepartmentDTO from;
    private DepartmentDTO to;
    private UserDTO recipient;
    private UserDTO sender;
    private String description;
    private Status status;

    public enum Status {
        ACCEPTED,
        IN_TRANSIT,
        ARRIVED,
        RECEIVED
    }

}
