package org.excise.rsbcl.dao.newsUpdates;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsUpdatesDAO {
    private ObjectId id;

    @NotNull(message = "News title is required")
    @NotEmpty(message = "News title cannot be empty")
    @Size(max = 200, message = "Title should not be more than 200 characters")
    private String title;

    @NotNull(message = "Description is required")
    @NotEmpty(message = "Description cannot be empty")
    @Size(max = 500, message = "Description should not exceed 500 characters")
    private String description;

    @NotNull(message = "Department is required")
    @NotEmpty(message = "Department cannot be empty")
    private String department;

    private String fileSize;  // Optional field
    private LocalDate lastUpdate;
    private MultipartFile document;

    @NotNull(message = "Status is required")
    private String newsStatus;
}
