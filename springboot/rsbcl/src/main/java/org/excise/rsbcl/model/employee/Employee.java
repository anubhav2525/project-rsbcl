package org.excise.rsbcl.model.employee;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private ObjectId id;

    @NotNull(message = "First name cannot be null")
    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, max = 60, message = "Last name must be between 1 and 60 characters")
    private String lastName;

    @NotNull(message = "Gender cannot be null")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;
    private String dateOfBirth;

    @NotNull(message = "Aadhar number cannot be null")
    @Size(min = 12, max = 12, message = "Aadhar number must be 12 digits")
    private String aadharNumber;

    @NotNull(message = "Phone number cannot be null")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Indexed(unique = true)
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Address cannot be null")
    private Address address;
    private String dateOfJoining;

    @NotNull(message = "Job title cannot be null")
    @Size(min = 1, max = 100, message = "Job title must be between 1 and 100 characters")
    private String jobTitle;

    @NotNull(message = "Salary cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    private BigDecimal salary;

    @NotNull(message = "Employment type cannot be null")
    @Size(min = 1, max = 50, message = "Employment type must be between 1 and 50 characters")
    private String employmentType;

    @NotNull(message = "Created by cannot be null")
    @Size(min = 1, max = 50, message = "Created by must be between 1 and 50 characters")
    private String createdBy;
    private boolean status = true;
    private LocalDateTime lastUpdated;

    @NotNull(message = "Username cannot be null")
    @Size(min = 1, max = 50, message = "Username must be between 1 and 50 characters")
    private String username;
    private List<String> roles = new ArrayList<>();

    @NotNull(message = "Department name cannot be null")
    @Size(min = 1, max = 100, message = "Department name must be between 1 and 100 characters")
    private String departmentName;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Address {
        @NotNull(message = "City cannot be null")
        @Size(min = 1, max = 50, message = "City must be between 1 and 50 characters")
        private String city;

        @NotNull(message = "State cannot be null")
        @Size(min = 1, max = 50, message = "State must be between 1 and 50 characters")
        private String state;

        @Min(value = 100000, message = "Pincode must be a valid 6-digit number")
        @Max(value = 999999, message = "Pincode must be a valid 6-digit number")
        private int pincode;

        @NotNull(message = "Country cannot be null")
        @Size(min = 1, max = 50, message = "Country must be between 1 and 50 characters")
        private String country;

        @NotNull(message = "Street address cannot be null")
        @Size(min = 1, max = 255, message = "Street address must be between 1 and 255 characters")
        private String streetAddress;
    }
}
