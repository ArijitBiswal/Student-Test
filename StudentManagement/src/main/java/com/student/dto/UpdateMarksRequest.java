package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMarksRequest {

    @NotNull(message = "Marks 1 is mandatory")
    @Min(value = 0, message = "Marks should be at least 0")
    @Max(value = 100, message = "Marks should not exceed 100")
    private double marks1;

    @NotNull(message = "Marks 2 is mandatory")
    @Min(value = 0, message = "Marks should be at least 0")
    @Max(value = 100, message = "Marks should not exceed 100")
    private double marks2;

    @NotNull(message = "Marks 3 is mandatory")
    @Min(value = 0, message = "Marks should be at least 0")
    @Max(value = 100, message = "Marks should not exceed 100")
    private double marks3;

}
