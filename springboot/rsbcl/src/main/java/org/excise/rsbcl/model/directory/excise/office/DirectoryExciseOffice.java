package org.excise.rsbcl.model.directory.excise.office;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "directory_excise_office")
public class DirectoryExciseOffice {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private int sno;
    private String name;
    private String designation;
    private String mobileNo;
    private String stdCode;
    private String office;
    private String faxNo;
    private String email;
}
