package com.udea.proyecto.compumovil.controller;

import com.udea.proyecto.compumovil.model.dto.UsuarioDTO;
import com.udea.proyecto.compumovil.model.dto.auth.LoginUserDto;
import com.udea.proyecto.compumovil.model.dto.auth.ResponseAuth;
import com.udea.proyecto.compumovil.service.auth.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
    @Operation(summary = "Hello Test Endpoint", description = "Returns a test greeting message.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response"),
            @ApiResponse(responseCode = "403", description = "Access Denied")
    })
    @PreAuthorize("isAuthenticated()") // Solo usuarios autenticados pueden acceder
    @GetMapping("/test")
    public String helloTest() {
        return "Hello Test";
    }

    @Operation(summary = "Hello Admin Endpoint", description = "Returns a greeting message for admins.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response"),
            @ApiResponse(responseCode = "403", description = "Access Denied")
    })
    @PreAuthorize("hasRole('ADMIN')") // Solo usuarios con rol ADMIN pueden acceder
    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello Admin";
    }

    @Operation(summary = "Hello User Endpoint", description = "Returns a greeting message for users.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response"),
            @ApiResponse(responseCode = "403", description = "Access Denied")
    })
    @PreAuthorize("hasRole('USER')") // Solo usuarios con rol USER pueden acceder
    @GetMapping("/user")
    public String helloUser() {
        return "Hello user";
    }


}
