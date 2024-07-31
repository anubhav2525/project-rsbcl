package org.excise.rsbcl.services.employee.roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.employee.roles.Roles;
import org.excise.rsbcl.repository.employee.RolesRepo.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RolesService {
    @Autowired
    private final RolesRepo rolesRepo;

    public RolesService(RolesRepo rolesRepo) {
        this.rolesRepo = rolesRepo;
    }

    // role exists for employee
    public boolean roleExists(String role) {
        return rolesRepo.findByRole(role).isPresent();
    }

    // role exists for employee
    public Response<Boolean> roleExistsOrNot(String role) {
        boolean responseEntity = rolesRepo.findByRole(role).isPresent();
        if (responseEntity) return new Response<>("Success", "Role Match", true);
        return new Response<>("Error404", "Role not match", false);
    }

    public Response<List<Roles>> getAllRoles() {
        try {
            List<Roles> roles = rolesRepo.findAll();
            if (roles.isEmpty()) return new Response<>("Error404", "Roles not found", null);
            return new Response<>("Success", "Roles are found", roles);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Roles> getRoleById(ObjectId id) {
        try {
            Roles role = rolesRepo.findById(id).orElse(null);
            if (role != null) return new Response<>("Success", "Role is found", role);
            return new Response<>("Error404", "Role is not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Roles> getRoleByRoleName(String roleName) {
        try {
            Roles roles = rolesRepo.findByRole(roleName).orElse(null);
            if (roles != null) return new Response<>("Success", "Role is found", roles);
            return new Response<>("Error404", "Role is not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Roles> saveRole(Roles roles) {
        try {
            Roles oldRole = rolesRepo.findByRole(roles.getRole()).orElse(null);
            if (oldRole != null) {
                return new Response<>("Error404", "Role is already exists", null);
            }
            roles.setLastUpdate(LocalDateTime.now());
            Roles savedRole = rolesRepo.save(roles);
            return new Response<>("Success", "Role added successfully", savedRole);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Roles> updateRoleById(ObjectId id, Roles roles) {
        try {
            Roles oldrole = rolesRepo.findById(id).orElse(null);
            if (oldrole != null) {
                oldrole.setRole(roles.getRole());
                oldrole.setDescription(roles.getDescription());
                Roles savedRole = rolesRepo.save(oldrole);
                return new Response<>("Success", "Role updated successfully", savedRole);
            }
            return new Response<>("Error404", "Role not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Roles> updateRoleByName(String roleName, Roles roles) {
        try {
            Roles oldrole = rolesRepo.findByRole(roleName).orElse(null);
            if (oldrole != null) {
                oldrole.setRole(roles.getRole());
                oldrole.setDescription(roles.getDescription());
                oldrole.setLastUpdate(LocalDateTime.now());
                Roles savedRole = rolesRepo.save(oldrole);
                return new Response<>("Success", "Role updated successfully", savedRole);
            }
            return new Response<>("Error404", "Role not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Void> deleteRoleById(ObjectId id) {
        try {
            Roles oldRole = rolesRepo.findById(id).orElse(null);
            if (oldRole != null) {
                rolesRepo.deleteById(id);
                return new Response<>("Success", "Role is deleted", null);
            }
            return new Response<>("Error404", "Role not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Void> deleteRoleByRoleName(String roleName) {
        try {
            Roles oldRole = rolesRepo.findByRole(roleName).orElse(null);
            if (oldRole != null) {
                rolesRepo.deleteByRole(roleName);
                return new Response<>("Success", "Role is deleted", null);
            }
            return new Response<>("Error404", "Role not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    // Response static class
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response<T> {
        private String status;
        private String message;
        private T data;
    }
}
