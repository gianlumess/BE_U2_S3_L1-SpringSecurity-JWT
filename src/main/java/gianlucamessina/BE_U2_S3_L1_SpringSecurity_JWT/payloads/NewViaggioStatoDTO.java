package gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.payloads;

import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.enums.StatoViaggio;
import jakarta.validation.constraints.NotNull;

public record NewViaggioStatoDTO(@NotNull(message = "devi passare un valore tra 'IN_PROGRAMMA' e 'COMPLETATO', non può essere vuoto!")
                                 StatoViaggio statoViaggio) {
}
