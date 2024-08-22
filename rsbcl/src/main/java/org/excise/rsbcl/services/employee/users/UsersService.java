package org.excise.rsbcl.services.employee.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.excise.rsbcl.controllers.employee.users.UserController;
import org.excise.rsbcl.model.employee.Employee;
import org.excise.rsbcl.model.employee.users.UserForget;
import org.excise.rsbcl.model.employee.users.Users;
import org.excise.rsbcl.repository.employee.EmployeeRepo;
import org.excise.rsbcl.repository.employee.UsersRepo.UserForgetRepo;
import org.excise.rsbcl.repository.employee.UsersRepo.UsersRepo;
import org.excise.rsbcl.services.JWTService;
import org.excise.rsbcl.services.emailService.EmailService;
import org.excise.rsbcl.services.employee.EmployeeService;
import org.excise.rsbcl.services.employee.RandomPasswordGenerator;
import org.excise.rsbcl.services.otpGenerator.OtpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private final UsersRepo usersRepo;
    @Autowired
    private final RandomPasswordGenerator randomPasswordGenerator;
    @Autowired
    private final UserForgetRepo userForgetRepo;
    @Autowired
    private final EmployeeRepo employeeRepo;
    @Autowired
    private final EmailService emailService;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailServiceImpl userDetailService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UsersService(UsersRepo usersRepo, RandomPasswordGenerator randomPasswordGenerator, UserForgetRepo userForgetRepo, EmployeeRepo employeeRepo, EmailService emailService) {
        this.usersRepo = usersRepo;
        this.randomPasswordGenerator = randomPasswordGenerator;
        this.userForgetRepo = userForgetRepo;
        this.employeeRepo = employeeRepo;
        this.emailService = emailService;
    }

    // checking existence of username
    public boolean usernameExists(String username) {
        return usersRepo.findByUsername(username).isPresent();
    }

    public Response<List<Users>> getAllUsers() {
        try {
            List<Users> users = usersRepo.findAll();
            if (users.isEmpty()) return new Response<>("Error404", "Users not exists (no more logins)", null);
            return new Response<>("Success", "Users found", users);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    // save new user by employeeService
    public void saveUser(EmployeeService.UserGenerator userGenerator) {
        Users user = new Users();
        user.setEmployeeId(userGenerator.getEmployeeId());
        user.setUsername(userGenerator.getUsername());
        user.setPassword(randomPasswordGenerator.hashPassword(userGenerator.getPassword()));
        user.setRoles(userGenerator.getRoles());
        user.setLastUpdate(userGenerator.getLastUpdate());
        usersRepo.save(user);
    }

    public Response<String> login(UserController.UserLoginAssests userLoginAssests) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginAssests.getUsername(), userLoginAssests.getPassword()));
            UserDetails userDetails = userDetailService.loadUserByUsername(userLoginAssests.getUsername());
            String jwt = jwtService.generateToken(userDetails.getUsername());
            return new Response<>("Success", "User found", jwt);
        } catch (Exception e) {
            return new Response<>("Error", "Login error: " + e.getMessage(), null);
        }
    }

//    public Response<?> userLogin(Users user) {
//        try {
//            Users oldUser = usersRepo.findByUsername(user.getUsername()).orElse(null);
//            if (oldUser != null) {
//                if (passwordEncoder.matches(user.getPassword(), oldUser.getPassword())) {
//                    // Generate JWT token
//                    String token = jwtService.generateToken(oldUser.getUsername());
//                    return new Response<>("Success", "Your credentials are correct", new UserCredentials(true, oldUser.getUsername(), token, oldUser.getRoles()));
//                }
//                return new Response<>("Error", "Wrong password!", null);
//            }
//            return new Response<>("Error404", "Wrong username and password", null);
//        } catch (Exception e) {
//            return new Response<>("Error", e.getMessage(), null);
//        }
//    }

    // delete user for employee
    public void deleteByUsername(String username) {
        usersRepo.deleteByUsername(username);
    }

    // update user for employee
//    @Transactional
//    public Response<?> forgetPassword(String username) {
//        try {
//            Users oldUser = usersRepo.findByUsername(username).orElse(null);
//            if (oldUser == null) return new Response<>("Error404", "Username not found", null);
//            Employee employee = employeeRepo.findByUsername(username).orElse(null);
//            if (employee == null) return new Response<>("Error404", "Employee not found", null);
//
//            String emailAddress = employee.getContactInfo().getEmail(); // get email address of employee db
//
//            // generate OTP
//            int otp = OtpGenerator.generateOtp();
//
//            // finding in UserForget
//            // Find or create UserForget entry
//            UserForget userForget = userForgetRepo.findByUsername(username).orElse(new UserForget());
//            userForget.setTime(LocalDateTime.now());
//            userForget.setUsername(username);
//            userForget.setOtp(otp);
//
//            // Send email
//            EmailService.Response<Void> response = emailService.sendEmail(emailAddress, "Forget password for username : " + employee.getJobInfo().getUsername(), "OTP received for forget password : " + otp);
//
//            if (response.getStatus().equals("Success")) {
//                userForgetRepo.save(userForget);
//                return new Response<>("Success", "Otp has been sent to the registered mail", userForget);
//            } else {
//                return new Response<>("Error", "Email could not be sent", null);
//            }
//        } catch (Exception e) {
//            return new Response<>("Error", e.getMessage(), null);
//        }
//    }

//    @Transactional
//    public Response<?> resetPassword(ResetEntity resetEntity) {
//        try {
//            // Find the user by username
//            Users oldUser = usersRepo.findByUsername(resetEntity.getUsername()).orElse(null);
//            if (oldUser == null) {
//                return new Response<>("Error404", "No valid credentials", null);
//            }
//
//            // Find the UserForget entity by username
//            UserForget userForget = userForgetRepo.findByUsername(resetEntity.getUsername()).orElse(null);
//            if (userForget == null) {
//                return new Response<>("Error404", "No valid token generated", null);
//            }
//
//            // Match the OTP
//            if (resetEntity.getOtp() == userForget.getOtp()) {
//                // Update the user's password
//                oldUser.setPassword(randomPasswordGenerator.hashPassword(resetEntity.getPassword()));
//                oldUser.setLastUpdate(LocalDateTime.now());
//                usersRepo.save(oldUser);
//
//                // Find the employee by username
//                Employee employee = employeeRepo.findByUsername(resetEntity.getUsername()).orElse(null);
//                if (employee == null) {
//                    return new Response<>("Error404", "Employee not found", null);
//                }
//
//                // Send confirmation email
//                EmailService.Response<Void> response = emailService.sendEmail(employee.getContactInfo().getEmail(), "Password changed for department: " + employee.getJobInfo().getDepartmentName(), "Your password has been changed. Username: " + resetEntity.getUsername() + ", new password: " + resetEntity.getPassword());
//
//                if (response.getStatus().equals("Success")) {
//                    userForgetRepo.deleteById(userForget.getId());
//                    return new Response<>("Success", "Password has been changed and email sent", null);
//                } else {
//                    return new Response<>("Error", "Password changed but email could not be sent", null);
//                }
//            } else {
//                return new Response<>("Error404", "OTP didn't match", resetEntity);
//            }
//        } catch (Exception e) {
//            return new Response<>("Error", "reset token : "+ e.getMessage(), null);
//        }
//    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response<T> {
        private String status;
        private String message;
        private T data;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserCredentials {
        private boolean status;
        private String username;
        private String token;
        private List<String> roles;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResetEntity {
        private String username;
        private int otp;
        private String password;
        private LocalDateTime time;
    }
}
