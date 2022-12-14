package uz.cargostream.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.cargostream.entity.admin.Admin;
import uz.cargostream.entity.admin.AdminRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    private final AdminRepository adminRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer") && authorization.length() > 7) {
            authorization = authorization.substring(7);
            String phoneNumber = jwtProvider.getPhoneNumber(authorization);
            if (phoneNumber != null) {

                Optional<Admin> optionalUser = adminRepository.findByPhoneNumber(phoneNumber);

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
                if (optionalUser.isPresent()) {
                    usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(optionalUser.get(), null, optionalUser.get().getAuthorities());
                }
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
        }

        filterChain.doFilter(request, response);
    }
}
