package org.excise.rsbcl.model.directory.rsbcl.depots;

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

@Document(collection = "directory_rsbcl_depots")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryRsbclDepots {
    @Id
    private ObjectId id;
    private int sno;

    @NotNull(message = "Deport name not be empty")
    @Size(min = 4, max = 40, message = "Deport name must be 1 to 40 characters")
    private String depotName;

    @NotNull(message = "Phone number not be empty")
    @Size(max = 10, message = "Phone number atleast 10 digits")
    private String phoneNo;

    @NotNull(message = "Deport address not be empty")
    @Size(max = 255, message = "Deport address max 255 characters")
    private String address;

    @Indexed(unique = true)
    @NotNull(message = "Deport email address not be empty")
    @Size(min = 4, max = 50, message = "Deport email address must be 1 to 50 characters")
    private String email;

    @NotNull(message = "Deport mobile no not be empty")
    @Size(min = 4, max = 12, message = "Deport mobile no must be 1 to 12 characters")
    private String mobileNo;

    private LocalDateTime lastUpdated;
}
