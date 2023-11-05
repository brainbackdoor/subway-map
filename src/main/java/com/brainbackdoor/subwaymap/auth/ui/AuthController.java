package com.brainbackdoor.subwaymap.auth.ui;

import com.brainbackdoor.subwaymap.auth.application.AuthService;
import com.brainbackdoor.subwaymap.auth.dto.TokenRequest;
import com.brainbackdoor.subwaymap.auth.dto.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login/token")
    public ResponseEntity<TokenResponse> login(@RequestBody TokenRequest request) {
        TokenResponse token = authService.login(request);
        return ResponseEntity.ok().body(token);
    }
}
