package org.excise.rsbcl.model.directory.rsbcl.office;

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

@Document(collection = "directory_rsbcl_office")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryRsbclOffice {
    @Id
    private ObjectId id;
    private int sno;

    @NotNull(message = "Designation not be empty")
    @Size(min = 1, max = 40, message = "Designation must be 1 to 40 characters")
    private String designation;

    @NotNull(message = "Name not be empty")
    @Size(min = 4, max = 50, message = "Name must be 1 to 50 characters")
    private String name;

    @NotNull(message = "Email address not be empty")
    @Size(min = 4, max = 50, message = "Email address must be 1 to 50 characters")
    private String email;

    @NotNull(message = "Phone number not be empty")
    @Size(max = 10, message = "Phone number atleast 10 digits")
    private String phoneNo;

    @NotNull(message = "Mobile no not be empty")
    @Size(min = 4, max = 12, message = "Mobile no must be 1 to 12 characters")
    private String mobileNo;
    private LocalDateTime lastUpdated;
}
