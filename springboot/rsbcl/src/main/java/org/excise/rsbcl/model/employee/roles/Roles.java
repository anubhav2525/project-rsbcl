package org.excise.rsbcl.model.employee.roles;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "employee_roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Roles {
    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NotNull(message = "Role cannot be null")
    @Size(min = 1, max = 100, message = "Role must be between 1 and 100 characters")
    private String role;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;
    private LocalDateTime lastUpdate;
}
