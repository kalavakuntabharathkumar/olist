package com.example.orders.controller;
import com.example.orders.security.JwtService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/auth")
public class AuthController {
  private final JwtService jwt;
  public AuthController(JwtService jwt){this.jwt=jwt;}
  @PostMapping("/token")
  public Map<String,String> token(@RequestParam String username,@RequestParam(defaultValue="ANALYST") String role){
    if(!username.equals("admin")&&!username.equals("analyst")) throw new IllegalArgumentException("Unknown demo user");
    if(username.equals("admin") && !role.equals("ADMIN")) role="ADMIN";
    if(username.equals("analyst")) role="ANALYST";
    return Map.of("access_token",jwt.token(username,role));
  }
}
