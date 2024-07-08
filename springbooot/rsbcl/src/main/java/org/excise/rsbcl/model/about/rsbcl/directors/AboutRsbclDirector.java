package org.excise.rsbcl.model.about.rsbcl.directors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "about_rsbcl_directors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsbclDirector {
    @Id
    private ObjectId id;
    private String name;
    private String address;
    private String designation;
    private String phoneNo;
}

