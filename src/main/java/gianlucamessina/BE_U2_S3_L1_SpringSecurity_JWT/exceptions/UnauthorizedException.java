package gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
