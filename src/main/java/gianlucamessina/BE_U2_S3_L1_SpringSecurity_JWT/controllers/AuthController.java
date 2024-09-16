package gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.controllers;

import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.payloads.DipendenteLoginDTO;
import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.payloads.DipendenteLoginRespDTO;
import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public DipendenteLoginRespDTO login(@RequestBody DipendenteLoginDTO payload){
        return new DipendenteLoginRespDTO(this.authService.controlloCredenzialiEdGenerazioneToken(payload));
    }
}
