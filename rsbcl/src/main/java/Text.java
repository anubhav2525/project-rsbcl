import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Text {

    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    // Method to hash a password
     static String hashPassword(String password) {
        return PASSWORD_ENCODER.encode(password);
    }

    public static void main(String[] args) {
        System.out.println(hashPassword("admin12345678"));
    }
}


