package vti.dtn.authservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import vti.dtn.authservice.dto.request.LoginRequest;
import vti.dtn.authservice.dto.response.LoginResponse;
import vti.dtn.authservice.dto.response.VerifyTokenResponse;
import vti.dtn.authservice.service.AuthenticationService;
import vti.dtn.authservice.service.JwtService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        LoginResponse loginResponse = authenticationService.login(loginRequest);
        return ResponseEntity
                .status(loginResponse.getStatus())
                .body(loginResponse);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<LoginResponse> refreshToken(@RequestHeader("Authorization") String authHeader) {
        LoginResponse response = authenticationService.refreshToken(authHeader);
        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    @GetMapping("/verify-token")
    public ResponseEntity<VerifyTokenResponse> verifyToken(@RequestHeader("Authorization") String authHeader) {
        log.info("Verifying token with header: {}", authHeader);
        VerifyTokenResponse response = authenticationService.verifyToken(authHeader);
        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }
}
