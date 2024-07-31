package org.excise.rsbcl.model.requirement;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "requirement")
public class Requirement {
    @Id
    private ObjectId id;

    @NotNull(message = "Position not be empty")
    private String position;

    @NotNull(message = "Department not be empty")
    private String department;

    @NotNull(message = "Job Role not be empty")
    private String role;

    @NotNull(message = "Description not be empty")
    private String description;

    @NotNull(message = "Notice link not be empty")
    private String noticeLink;

    @NotNull(message = "created By not be empty")
    private String createdBy;

    private boolean status;
    private LocalDate lastUpdate;
}
