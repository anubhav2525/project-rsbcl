package org.excise.rsbcl.model.about.rsbcl.directors;

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

@Document(collection = "about_rsbcl_directors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsbclDirector {
    @Id
    private ObjectId id;
    private int sno;

    @NotNull(message = "Name not be empty")
    private String name;

    @NotNull(message = "Address not be empty")
    private String address;

    @NotNull(message = "Designation not be empty")
    private String designation;

    @NotNull(message = "Phone no. not be empty")
    private String phoneNo;

    @Indexed(unique = true)
    @NotNull(message = "Email not be empty")
    @Size(min = 10, max = 40, message = "Email should be atleast 10 to 40 characters")
    private String email;

    private LocalDateTime lastUpdate;
}

