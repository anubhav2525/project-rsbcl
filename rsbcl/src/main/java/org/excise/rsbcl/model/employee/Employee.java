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
import java.time.LocalDate;
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

    @NotNull(message = "First name cannot be empty")
    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
    private String firstName;

    @Size(max = 50, message = "Middle name must be between 0 and 50 characters")
    private String middleName;

    @NotNull(message = "Last name cannot be empty")
    @Size(min = 1, max = 60, message = "Last name must be between 1 and 60 characters")
    private String lastName;

    @NotNull(message = "Gender cannot be empty")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Date of birth cannot be empty")
    private LocalDate dateOfBirth;

    @NotNull(message = "Phone number cannot be empty")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Indexed(unique = true)
    @NotNull(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Aadhar number cannot be empty")
    @Size(min = 12, max = 12, message = "Aadhar number must be 12 digits")
    private String aadharNumber;

    @NotNull(message = "Aadhar document cannot be empty")
    private String aadharDocument;

    @NotNull(message = "Pancard id cannot be empty")
    @Size(min = 10, max = 10, message = "Pancard must be 10 characters")
    private String pancardId;

    @NotNull(message = "Pancard document cannot be empty")
    private String pancardDocument;

    @NotNull(message = "Address cannot be empty")
    private Address address;

    @NotNull(message = "Date of joining cannot be empty")
    private LocalDate dateOfJoining;

    @NotNull(message = "Job title cannot be empty")
    @Size(min = 1, max = 100, message = "Job title must be between 1 and 100 characters")
    private String jobTitle;

    @NotNull(message = "Salary cannot be empty")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    private BigDecimal salary;

    @NotNull(message = "Employment type cannot be empty")
    private EmploymentType employmentType;

    @NotNull(message = "Created by cannot be empty")
    @Size(min = 1, max = 50, message = "Created by must be between 1 and 50 characters")
    private String createdBy;

    private boolean status = true;
    private LocalDateTime lastUpdated;

    @NotNull(message = "Username cannot be empty")
    @Size(min = 1, max = 50, message = "Username must be between 1 and 50 characters")
    private String username;
    private List<String> roles = new ArrayList<>();

    @NotNull(message = "Department name cannot be empty")
    @Size(min = 1, max = 100, message = "Department name must be between 1 and 100 characters")
    private String departmentName;

    @Size(max = 50, message = "Marital status must be between 0 and 50 characters")
    private String maritalStatus;

    @NotNull(message = "Emergency contact cannot be empty")
    @Size(min = 10, max = 10, message = "Emergency contact must be 10 digits")
    private String emergencyContact;

    @Size(max = 255, message = "Profile picture URL must be between 0 and 255 characters")
    private String profilePictureUrl;

    private List<EmploymentHistory> employmentHistory = new ArrayList<>();
    private List<Education> education = new ArrayList<>();
    private List<String> skills = new ArrayList<>();
    private boolean documentsVerified = false;

    public enum EmploymentType {
        FULL_TIME,
        PART_TIME,
        CONTRACT,
        INTERN
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {
        @NotNull(message = "City cannot be empty")
        @Size(min = 1, max = 50, message = "City must be between 1 and 50 characters")
        private String city;

        @NotNull(message = "State cannot be empty")
        @Size(min = 1, max = 50, message = "State must be between 1 and 50 characters")
        private String state;

        @Min(value = 100000, message = "Pincode must be a valid 6-digit number")
        @Max(value = 999999, message = "Pincode must be a valid 6-digit number")
        private int pincode;

        @NotNull(message = "Country cannot be empty")
        @Size(min = 1, max = 50, message = "Country must be between 1 and 50 characters")
        private String country;

        @NotNull(message = "Street address cannot be empty")
        @Size(min = 1, max = 255, message = "Street address must be between 1 and 255 characters")
        private String streetAddress;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EmploymentHistory {
        @NotNull(message = "Job title cannot be empty")
        @Size(min = 1, max = 100, message = "Job title must be between 1 and 100 characters")
        private String jobTitle;

        @NotNull(message = "Company name cannot be empty")
        @Size(min = 1, max = 100, message = "Company name must be between 1 and 100 characters")
        private String companyName;

        @NotNull(message = "Start date cannot be empty")
        private LocalDate startDate;
        private LocalDate endDate;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Education {
        @NotNull(message = "Degree cannot be empty")
        @Size(min = 1, max = 100, message = "Degree must be between 1 and 100 characters")
        private String degree;

        @NotNull(message = "Institution name cannot be empty")
        @Size(min = 1, max = 120, message = "Institution name must be between 1 and 120 characters")
        private String institutionName;

        @NotNull(message = "Year cannot be empty")
        private LocalDate year;
        private String documentUrl;
    }
}
