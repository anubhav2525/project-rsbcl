package org.excise.rsbcl.model.directory.rsgsm.reductionCenters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "directory_rsgsm_reductionCenter")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryRsgsmReductionCenter {
    @Id
    private ObjectId id;
    private String rcName;
    private String email;
}
