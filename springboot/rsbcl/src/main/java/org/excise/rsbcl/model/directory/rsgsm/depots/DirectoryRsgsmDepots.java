package org.excise.rsbcl.model.directory.rsgsm.depots;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "directory_rsgsm_depots")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryRsgsmDepots {
    @Id
    public ObjectId _id;
    @Indexed(unique = true)
    private int sno;
    public String depotName;
    public int camera;
    public int nvr;
    public int poe;
    public int cableRoll;
    public String person;
    public String mobileNo;
}
