package gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.security;

import gianlucamessina.BE_U2_S3_L1_SpringSecurity_JWT.entities.Dipendente;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTools {
    @Value("${jwt.secret}")
    private String secret;

    //dato un utente mi deve tornare il token
    public String createToken(Dipendente dipendente){
        return Jwts.builder().issuedAt(new Date(System.currentTimeMillis())) //data di emissione in millisecondi
                .expiration(new Date(System.currentTimeMillis()+1000+60+60+24+14))  //data di scadenza del token(sempre in millisecondi)
                .subject(String.valueOf(dipendente.getId()))  //indica a chi appartiene il token,NON bisogna mettere dati sensibili
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))  //firmo il token utilizzando un algoritmo apposito e il segreto
                .compact();
    }

    public void verifyToken(String token){}
}
