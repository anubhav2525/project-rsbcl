package org.excise.rsbcl.services.otpGenerator;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class OtpGenerator {

    private static final SecureRandom random = new SecureRandom();
    private static final int OTP_LENGTH = 6;

    @Bean
    public static int generateOtp() {
        int otp = 0;
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp = otp * 10 + random.nextInt(10);
        }
        return otp;
    }
}
