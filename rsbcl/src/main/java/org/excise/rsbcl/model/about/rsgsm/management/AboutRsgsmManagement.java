package org.excise.rsbcl.model.about.rsgsm.management;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "about_rsgsm_management")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsgsmManagement {
    @Id
    private ObjectId id;
    private int sno;
    private String name;
    private String post;
    private String as;
    private LocalDateTime lastUpdate;
}
