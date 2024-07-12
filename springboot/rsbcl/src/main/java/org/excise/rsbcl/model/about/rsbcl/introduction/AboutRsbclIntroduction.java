package org.excise.rsbcl.model.about.rsbcl.introduction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "about_rsbcl_introduction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsbclIntroduction {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private int sno;
    private String content;
}
