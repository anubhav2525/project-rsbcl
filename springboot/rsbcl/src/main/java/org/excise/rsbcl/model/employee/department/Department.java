package org.excise.rsbcl.model.employee.department;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NotNull(message = "Department name cannot be null")
    @Size(min = 1, max = 100, message = "Department name must be between 1 and 100 characters")
    private String departmentName;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    @Min(value = 1, message = "Department size must be at least 1")
    private int departmentSize;

    private LocalDateTime lastUpdate;
    private boolean status = true;
}
