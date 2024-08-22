package org.excise.rsbcl.dao.inFocus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InFocusDAO {
    private ObjectId id;

    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "Website link cannot be null")
    private String links;
    private LocalDateTime lastUpdate;
    private String status;
}
