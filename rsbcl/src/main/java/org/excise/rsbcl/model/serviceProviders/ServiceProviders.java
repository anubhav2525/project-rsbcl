package org.excise.rsbcl.model.serviceProviders;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "service_providers")
public class ServiceProviders {
    @Id
    private ObjectId id;

    @NotNull(message = "Title should not be null")
    @Size(min = 5, max = 40, message = "Title should be between 5 and 40 characters")
    private String title;

    @NotNull(message = "Link should not be null")
    private String link;

    @NotNull(message = "Status not be null")
    @NotEmpty(message = "Status not be empty")
    @Pattern(regexp = "ACTIVE|REMOVED|DELETED|INACTIVE", message = "Status should be ACTIVE, REMOVED, DELETED, INACTIVE")
    private String status;

    @NotNull(message = "Category not be null")
    @NotEmpty(message = "Category not be empty")
    @Pattern(regexp = "LIQUOR|RETAIL|PUBLIC", message = "Category should be liquor, retail, public")
    private String category; // LIQUOR, RETAIL, PUBLIC

    private LocalDateTime lastUpdate;
}
