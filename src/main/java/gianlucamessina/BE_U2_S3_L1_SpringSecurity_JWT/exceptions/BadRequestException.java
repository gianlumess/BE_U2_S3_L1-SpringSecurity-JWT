package gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
