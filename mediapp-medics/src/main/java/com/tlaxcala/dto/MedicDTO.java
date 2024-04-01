package com.tlaxcala.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MedicDTO {

    @EqualsAndHashCode.Include
    private Integer idMedic;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    private String lastName;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 12)
    private String codMedic;

    @NotNull
    @NotEmpty
    private String photo;

}
