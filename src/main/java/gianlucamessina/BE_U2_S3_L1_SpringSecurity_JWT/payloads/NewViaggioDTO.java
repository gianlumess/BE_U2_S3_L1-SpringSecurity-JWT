package gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.payloads;

import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.enums.StatoViaggio;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewViaggioDTO(@NotEmpty(message = "La destinazione è obbligatoria!")
                            @Size(min = 3,message = "La destinazione deve essere composta da almeno 3 caratteri!")
                            String destinazione,
                            @NotNull(message = "La data è obbligatoria")
                            LocalDate data,
                            StatoViaggio statoViaggio) {
}
