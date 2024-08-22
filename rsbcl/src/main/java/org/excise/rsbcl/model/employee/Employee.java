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

    @Size(max = 50, message = "Marital status must be between 0 and 50 characters")
    private String maritalStatus;
    private String profilePictureUrl;

    @NotNull(message = "Phone number cannot be empty")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Indexed(unique = true)
    @NotNull(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Emergency contact cannot be empty")
    @Size(min = 10, max = 10, message = "Emergency contact must be 10 digits")
    private String emergencyContact;

    @NotNull(message = "Address cannot be empty")
    private Address address;

    @NotNull(message = "Aadhar number cannot be empty")
    @Size(min = 12, max = 12, message = "Aadhar number must be 12 digits")
    private String aadharNumber;

//        @NotNull(message = "Aadhar document cannot be empty")
//        private String aadharDocumentUrl;

    @NotNull(message = "Pancard id cannot be empty")
    @Size(min = 10, max = 10, message = "Pancard must be 10 characters")
    private String pancardId;

    @NotNull(message = "Created by cannot be empty")
    @Size(min = 1, max = 50, message = "Created by must be between 1 and 50 characters")
    private String createdBy;

    @NotNull(message = "Username cannot be empty")
    @Size(min = 1, max = 50, message = "Username must be between 1 and 50 characters")
    private String username;

    @NotNull(message = "Department name cannot be empty")
    @Size(min = 1, max = 100, message = "Department name must be between 1 and 100 characters")
    private String departmentName;

    @NotNull(message = "Job details cannot be empty")
    private JobDetail jobDetail;
    private List<String> roles = new ArrayList<>();

    @NotNull(message = "Branch name cannot be empty")
    @Size(min = 1, max = 100, message = "Branch name must be between 1 and 100 characters")
    private String branch;
    private List<EmploymentHistory> employmentHistory = new ArrayList<>();
    private List<Education> educations = new ArrayList<>();
    private List<String> skills = new ArrayList<>();
    private boolean documentsVerified = false;
    private LocalDateTime lastUpdated;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JobDetail {
        @NotNull(message = "Job title cannot be empty")
        @Size(min = 1, max = 100, message = "Job title must be between 1 and 100 characters")
        private String jobTitle;

        @NotNull(message = "Salary cannot be empty")
        @DecimalMin(value = "0.00", inclusive = false, message = "Salary must be greater than 0")
        private BigDecimal salary;
        private List<String> skills = new ArrayList<>();

        @NotNull(message = "Employment type cannot be empty")
        private String employmentType;
        private String employeeStatus;

        @NotNull(message = "Date of joining cannot be empty")
        private LocalDate dateOfJoining;
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
        @Size(min = 1, max = 100, message = "Job title must be between 1 and 100 characters")
        private String jobTitle;

        @Size(min = 1, max = 100, message = "Company name must be between 1 and 100 characters")
        private String companyName;

        private String yearOfExperience;
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
        private String year;
//        private String documentUrl;
    }
}
