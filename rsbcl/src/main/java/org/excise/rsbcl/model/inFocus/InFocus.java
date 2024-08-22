package org.excise.rsbcl.model.inFocus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "in_focus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InFocus {
    @Id
    private ObjectId id;

    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "Website link cannot be null")
    private String links;
    private LocalDateTime lastUpdate;
    private String status;
}
