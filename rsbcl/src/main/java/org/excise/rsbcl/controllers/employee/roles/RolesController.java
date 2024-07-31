package org.excise.rsbcl.controllers.employee.roles;

import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.employee.roles.Roles;
import org.excise.rsbcl.services.employee.roles.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RolesController {
    @Autowired
    public final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/v1/auth/roles")
    public ResponseEntity<?> getAllRoles() {
        RolesService.Response<List<Roles>> response = rolesService.getAllRoles();
        return createResponseEntity(response);
    }

    @GetMapping("/v1/auth/role/name/{roleName}")
    public ResponseEntity<?> getRoleByName(@PathVariable("roleName") String roleName) {
        RolesService.Response<Boolean> response = rolesService.roleExistsOrNot(roleName);
        return createResponseEntity(response);
    }

    @GetMapping("/v1/auth/role/id/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable("id") ObjectId id) {
        RolesService.Response<Roles> rolesResponse = rolesService.getRoleById(id);
        return createResponseEntity(rolesResponse);
    }

    @PostMapping("/v1/auth/role")
    public ResponseEntity<?> saveRole(@Valid @RequestBody Roles roles, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        RolesService.Response<Roles> rolesResponse = rolesService.saveRole(roles);
        return createResponseEntity(rolesResponse);
    }

    @PutMapping("/v1/auth/role/id/{id}")
    public ResponseEntity<?> updateRoleById(@PathVariable("id") ObjectId id, Roles roles) {
        RolesService.Response<Roles> rolesResponse = rolesService.updateRoleById(id, roles);
        return createResponseEntity(rolesResponse);
    }

    @PutMapping("/v1/auth/role/name/{roleName}")
    public ResponseEntity<?> updateRoleByRoleName(@PathVariable("roleName") String roleName, Roles roles) {
        RolesService.Response<Roles> rolesResponse = rolesService.updateRoleByName(roleName, roles);
        return createResponseEntity(rolesResponse);
    }

    @DeleteMapping("/v1/auth/role/id/{id}")
    public ResponseEntity<?> deleteRoleById(@PathVariable("id") ObjectId id) {
        RolesService.Response<?> rolesResponse = rolesService.deleteRoleById(id);
        return createResponseEntity(rolesResponse);
    }

    @DeleteMapping("/v1/auth/role/name/{roleName}")
    public ResponseEntity<?> deleteRoleByRoleName(@PathVariable("roleName") String roleName) {
        RolesService.Response<?> rolesResponse = rolesService.deleteRoleByRoleName(roleName);
        return createResponseEntity(rolesResponse);
    }

    private <T> ResponseEntity<?> createResponseEntity(RolesService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Error403" -> new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            default -> new ResponseEntity<>("Unknown status", HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
