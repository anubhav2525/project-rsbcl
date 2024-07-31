package org.excise.rsbcl.model.directory.rsgsm.reductionCenters;

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

@Document(collection = "directory_rsgsm_reductionCenter")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryRsgsmReductionCenter {
    @Id
    private ObjectId id;
    private int sno;

    @NotNull(message = "RC name not be empty")
    private String rcName;

    @Indexed(unique = true)
    @NotNull(message = "Email not be empty")
    @Size(min = 10,max = 50,message = "Email address should be 10 to 50 characters")
    private String email;
    private LocalDateTime lastUpdate;
}
