package com.example.orders.security;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {
  private final JwtService jwt;
  public JwtFilter(JwtService jwt){this.jwt=jwt;}
  protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res,FilterChain chain)throws IOException,ServletException{
    String h=req.getHeader("Authorization");
    if(h!=null && h.startsWith("Bearer ")){try{
      var c=jwt.parse(h.substring(7)).getPayload(); String role=c.get("role",String.class);
      var auth=new UsernamePasswordAuthenticationToken(c.getSubject(),null,java.util.List.of(new SimpleGrantedAuthority("ROLE_"+role)));
      SecurityContextHolder.getContext().setAuthentication(auth);
    }catch(Exception ignored){}}
    chain.doFilter(req,res);
  }
}
