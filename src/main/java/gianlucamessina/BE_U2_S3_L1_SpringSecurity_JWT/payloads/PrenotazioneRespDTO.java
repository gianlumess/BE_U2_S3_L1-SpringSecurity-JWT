package gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.payloads;

import java.time.LocalDate;
import java.util.UUID;

public record PrenotazioneRespDTO(UUID id,
                                  LocalDate dataRichiesta,
                                  String volo,
                                  String alloggio,
                                  String dipendenteId,
                                  String viaggioId) {
}
