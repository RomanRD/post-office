package org.romanhorkun.departmentservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ParcelDTO {

    private String id;
    private DepartmentDTO from;
    private DepartmentDTO to;

}
