package org.excise.rsbcl.model.mobileApp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.excise.rsbcl.configuration.ObjectIdJsonDeserializer;
import org.excise.rsbcl.configuration.ObjectIdJsonSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "mobile_apps")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileApp {
    @Id
    @JsonSerialize(using = ObjectIdJsonSerializer.class)
    @JsonDeserialize(using = ObjectIdJsonDeserializer.class)
    private ObjectId id;

    @Indexed(unique = true)
    @NotNull(message = "App name cannot be empty")
    @Size(min = 1, max = 100, message = "App name must be between 1 and 100 characters")
    private String appName;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    @NotNull(message = "Description not be empty")
    private String description;

    @NotNull(message = "Link cannot be empty")
    private String link;

    @NotNull(message = "Document link not be empty")
    private String documentLink;

    @NotNull(message = "Video link not be empty")
    private String videoLink;

    @NotNull(message = "Application image link not be empty")
    private String applicationImageLink;

    @Size(max = 500, message = "Suggestion cannot exceed 500 characters")
    private String suggestion;

    @NotNull(message = "Version cannot be empty")
    @Size(min = 1, max = 50, message = "Version must be between 1 and 50 characters")
    private String version;
    private boolean status = true;
    private LocalDateTime lastUpdate;
}
