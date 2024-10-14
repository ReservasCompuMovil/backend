package com.udea.proyecto.compumovil.model.dto;

import com.udea.proyecto.compumovil.model.enums.RoleEnum;
import lombok.*;


@Data
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String cedula;
    private String correo;
    private String contrasena;

    @NonNull
    private RoleEnum rol;
}
