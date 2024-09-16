package gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.controllers;

import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.entities.Dipendente;
import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.exceptions.BadRequestException;
import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.payloads.DipendenteLoginDTO;
import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.payloads.DipendenteLoginRespDTO;
import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.payloads.NewDipendenteDTO;
import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.services.AuthService;
import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    DipendenteService dipendenteService;

    @PostMapping("/login")
    public DipendenteLoginRespDTO login(@RequestBody DipendenteLoginDTO payload){
        return new DipendenteLoginRespDTO(this.authService.controlloCredenzialiEdGenerazioneToken(payload));
    }

    //POST (http://localhost:3001/auth/register)
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente save(@RequestBody @Validated NewDipendenteDTO body, BindingResult validation){
        // @Validated serve per 'attivare' le regole di validazione descritte nel DTO
        // BindingResult permette di capire se ci sono stati errori e quali

        if(validation.hasErrors()){
            String messages=validation.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.joining(". "));

            throw new BadRequestException("ci sono stati errori nel payload: "+messages);
        }

        return this.dipendenteService.save(body);
    }

}
