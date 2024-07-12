package org.excise.rsbcl.model.directory.rsbcl.depots;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "directory_rsbcl_depots")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryRsbclDepots {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private int sno;
    private String depotName;
    private String phoneNo;
    private String address;
    private String email;
    private String mobileNo;
}
