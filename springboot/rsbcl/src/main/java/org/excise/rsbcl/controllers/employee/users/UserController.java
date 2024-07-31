package org.excise.rsbcl.controllers.employee.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.excise.rsbcl.model.employee.users.Users;
import org.excise.rsbcl.services.employee.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/public")
public class UserController {
    @Autowired
    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginAssests userLoginAssests) {
        UsersService.Response<String> response = usersService.login(userLoginAssests);
        if (response.getStatus().equals("Success")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(response);
        }
    }

    @PostMapping("/username/{username}")
    public ResponseEntity<?> forgetPassword(@PathVariable("username") String username) {
        UsersService.Response<?> response = usersService.forgetPassword(username);
        return createResponseEntity(response);
    }

    @PutMapping("/reset-account")
    public ResponseEntity<?> updatePassword(@RequestBody UsersService.ResetEntity resetEntity) {
        UsersService.Response<?> response = usersService.resetPassword(resetEntity);
        return createResponseEntity(response);
    }

    private ResponseEntity<?> createResponseEntity(UsersService.Response<?> response) {
        return switch (response.getStatus()) {
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            case "Error208" -> new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
            default ->
                    new ResponseEntity<>("Unknown status" + response.getMessage() + " /// " + response.getData(), HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserLoginAssests{
        private String username;
        private String password;
    }
}
