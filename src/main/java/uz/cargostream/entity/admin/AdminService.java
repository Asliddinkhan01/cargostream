package uz.cargostream.entity.admin;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.cargostream.common.ApiResponse;
import uz.cargostream.entity.admin.dto.LoginDto;
import uz.cargostream.entity.admin.enums.Role;
import uz.cargostream.security.JwtProvider;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService implements UserDetailsService {

    private final AdminRepository adminRepository;

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return adminRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new UsernameNotFoundException(phoneNumber));
    }

    public HttpEntity<?> loginUser(LoginDto loginDto) {
        Optional<Admin> optionalUser = adminRepository.findByPhoneNumber(loginDto.getPhoneNumber());

        if (optionalUser.isEmpty())
            return new ResponseEntity<>(new ApiResponse("Phone number or password wrong", false), HttpStatus.CONFLICT);

        Admin admin = optionalUser.get();
        if (admin.getPassword().equals(loginDto.getPassword()))
            return new ResponseEntity<>(new ApiResponse("Phone number or password wrong", false), HttpStatus.CONFLICT);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginDto.getPhoneNumber(), loginDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        Admin authenticatedUser = (Admin) authenticate.getPrincipal();
        String token = jwtProvider.generateToken(authenticatedUser.getPhoneNumber(), authenticatedUser.getRole());

        return ResponseEntity.status(200).body(new ApiResponse("Successful signed in.", true, token));
    }

    public HttpEntity<?> addAdmin(LoginDto loginDto) {

        Admin admin = new Admin();

        admin.setPassword(loginDto.getPassword());
        admin.setPhoneNumber(loginDto.getPhoneNumber());
        admin.setRole(Role.ADMIN);

        adminRepository.save(admin);
        return new ResponseEntity<>(new ApiResponse("Success", true), HttpStatus.CREATED);
    }
}
