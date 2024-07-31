package org.excise.rsbcl.model.directory.excise.office;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "directory_excise_office")
public class DirectoryExciseOffice {
    @Id
    private ObjectId id;
    private int sno;

    @NotNull(message = "Name is required")
    @Size(min = 10, max = 50, message = "Name must be between 1 to 50 characters")
    private String name;

    @NotNull(message = "Designation is required")
    private String designation;

    @NotNull(message = "Mobile no. required")
    @Size(min = 10,message = "Mobile no. should min 10 digits")
    private String mobileNo;
    private String stdCode;
    private String office;
    private String faxNo;

    @NotNull(message = "Email is required")
    @Size(min = 10,max = 50,message = "Email should be characters between 10 to 50")
    @Indexed(unique = true)
    private String email;

    private LocalDateTime lastUpdate;
}
