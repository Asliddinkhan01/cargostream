package uz.cargostream.entity.admin;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.cargostream.entity.admin.dto.LoginDto;

import javax.validation.Valid;

@RestController
@RequestMapping("${app.domain}/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/login")
    public HttpEntity<?> loginUser(@Valid @RequestBody LoginDto loginDto) {
        return adminService.loginUser(loginDto);
    }

    @PostMapping("/add")
    public HttpEntity<?> addAdmin(@Valid @RequestBody LoginDto loginDto) {
        return adminService.addAdmin(loginDto);
    }
}
