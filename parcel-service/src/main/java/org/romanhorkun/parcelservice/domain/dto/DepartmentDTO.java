package org.romanhorkun.parcelservice.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDTO {

    @NotNull
    private Integer id;
    private String address;

}
