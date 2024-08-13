package org.excise.rsbcl.model.about.excise.introduction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "about_excise_introduction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutExciseIntroduction {
    @Id
    private ObjectId id;
    private int sno;

    @NotNull(message = "Excise content not be empty")
    @Size( max = 255, message = "Content max 255 characters")
    private String content;

    private LocalDateTime lastUpdate;
}
