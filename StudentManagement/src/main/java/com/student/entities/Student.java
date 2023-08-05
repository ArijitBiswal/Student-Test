package com.student.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "First name should have a minimum length of 3 characters")
    private String firstName;

    @Size(min = 3, message = "Last name should have a minimum length of 3 characters")
    private String lastName;

    @Past
    @AgeRange
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @Min(value = 0, message = "Marks should be at least 0")
    @Max(value = 100, message = "Marks should not exceed 100")
    @NotNull(message = "Marks should not be null")
    private double mark1;
    @Min(value = 0, message = "Marks should be at least 0")
    @Max(value = 100, message = "Marks should not exceed 100")
    @NotNull(message = "Marks should not be null")
    private double mark2;
    @Min(value = 0, message = "Marks should be at least 0")
    @Max(value = 100, message = "Marks should not exceed 100")
    @NotNull(message = "Marks should not be null")
    private double mark3;



    @Pattern(regexp = "[A-C]", message = "Invalid section")
    private String section;

    @Pattern(regexp = "[MF]", message = "Invalid gender")
    private String gender;

    private double total;

    private double average;

    private String result;

    public double calculateTotal() {
        // Calculate total marks
        return mark1+mark2+mark3;
    }

    public double calculateAverage() {
        // Calculate average marks
        return ( mark1+ mark2+mark3)/3;
    }

    public String calculateResult() {
        // Check if each subject has minimum marks
        if (calculateTotal() >= 35){
            return "Pass";
        } else {
            return "Fail";
        }
    }

    @PrePersist
    @PreUpdate
    public void calculateFields() {
        this.total = calculateTotal();
        this.average = calculateAverage();
        this.result = calculateResult();
    }

    // Getters and setters

    // You can add additional methods or constructors as needed

}


