package org.excise.rsbcl.model.employee.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users_forget")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForget {
    @Autowired
    private ObjectId id;

    @Indexed(unique = true)
    private String username;
    private int otp;
    private LocalDateTime time;
}
