package gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.services;

import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.entities.Dipendente;
import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.exceptions.UnauthorizedException;
import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.payloads.DipendenteLoginDTO;
import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private JWTTools jwtTools;

    public String controlloCredenzialiEdGenerazioneToken(DipendenteLoginDTO body){
        //controllo tramite email se l'utente esiste
        Dipendente found=this.dipendenteService.findByEmail(body.email());
        if(found.getPassword().equals(body.password())){
            return jwtTools.createToken(found);
        }else {
            throw  new UnauthorizedException("Credenziali sbagliate!");
        }
    }
}
