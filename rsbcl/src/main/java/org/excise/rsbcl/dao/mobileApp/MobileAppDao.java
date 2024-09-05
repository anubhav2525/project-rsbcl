package org.excise.rsbcl.dao.mobileApp;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileAppDao {
    private ObjectId id;

    @NotNull(message = "App name cannot be empty")
    @Size(min = 1, max = 100, message = "App name must be between 1 and 100 characters")
    private String appName;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    @NotNull(message = "Description not be empty")
    private String description;

    @NotNull(message = "Link cannot be empty")
    private String link;

    @NotNull(message = "Document not be empty")
    private MultipartFile document;

    @NotNull(message = "Video not be empty")
    private MultipartFile video;

    @NotNull(message = "Application image not be empty")
    private MultipartFile applicationImage;

    @Size(max = 500, message = "Suggestion cannot exceed 500 characters")
    private String suggestion;

    @NotNull(message = "Version cannot be empty")
    @Size(min = 1, max = 50, message = "Version must be between 1 and 50 characters")
    private String version;

    @NotNull(message = "Status not be null")
    @NotEmpty(message = "Status not be empty")
    @Pattern(regexp = "ACTIVE|REMOVED|DELETED|INACTIVE", message = "Status should be ACTIVE, REMOVED, DELETED, INACTIVE")
    private String status;
    private LocalDateTime lastUpdate;
}
