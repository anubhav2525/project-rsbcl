package org.excise.rsbcl.model.directory.rsbcl.office;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "directory_rsbcl_office")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryRsbclOffice {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private int sno;
    private String designation;
    private String name;
    private String email;
    private String phoneNo;
    private String mobileNo;
}
