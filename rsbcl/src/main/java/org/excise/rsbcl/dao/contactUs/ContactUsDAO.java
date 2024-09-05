package org.excise.rsbcl.dao.contactUs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactUsDAO {
    private ObjectId id;

    @NotNull(message = "Branch cannot be null")
    @Size(min = 1, max = 100, message = "Branch must be between 1 and 100 characters")
    private String branch;

    @NotNull(message = "Address cannot be null")
    @Size(min = 1, max = 255, message = "Address must be between 1 and 255 characters")
    private String address;

    @NotNull(message = "Contact numbers cannot be null")
    @Size(min = 1, message = "There must be at least one contact number")
    private List<@NotNull(message = "Contact number cannot be null") @Size(min = 10, max = 15, message = "Contact number must be between 10 and 15 digits") String> contactNo;

    @Size(max = 15, message = "Fax number cannot exceed 15 digits")
    private String faxNo;

    @Indexed(unique = true)
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    private MultipartFile image;
    private boolean status;
    private LocalDateTime lastUpdate;
}
