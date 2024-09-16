package gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.payloads;

import java.time.LocalDateTime;

public record ErrorsResponseDTO(String message, LocalDateTime timeStamp) {
}
