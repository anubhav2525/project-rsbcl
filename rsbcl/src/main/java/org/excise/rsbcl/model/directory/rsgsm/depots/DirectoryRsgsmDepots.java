package org.excise.rsbcl.model.directory.rsgsm.depots;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "directory_rsgsm_depots")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryRsgsmDepots {
    @Id
    public ObjectId id;
    private int sno;

    @NotNull(message = "Deport name not be empty")
    public String depotName;

    @NotNull(message = "Camera not be empty")
    public int camera;

    @NotNull(message = "NVR not be empty")
    public int nvr;

    @NotNull(message = "POE not be empty")
    public int poe;

    @NotNull(message = "Cable roll not be empty")
    public int cableRoll;

    @NotNull(message = "Phone no. not be empty")
    public String person;

    @NotNull(message = "Mobile no. not be empty")
    public String mobileNo;
    public LocalDateTime lastUpdate;
}
