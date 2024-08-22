package org.excise.rsbcl.model.newsUpdates;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "news_updates")
public class NewsUpdates {
    @Id
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

    @NotNull(message = "Last update date is required")
    private LocalDate lastUpdate;

    @NotNull(message = "Document link URL is required")
    @NotEmpty(message = "Document link URL cannot be empty")
    private String documentLinkUrl;

    @NotNull(message = "Status is required")
    private String newsStatus;
}
