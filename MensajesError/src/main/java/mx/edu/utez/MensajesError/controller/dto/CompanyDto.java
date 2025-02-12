package mx.edu.utez.MensajesError.controller.dto;

import jakarta.persistence.Column;
import lombok.*;
import mx.edu.utez.MensajesError.models.Company;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDto {
    private String razon_social;
    private String rfc;
    private String telefono;
    private String contacto;
    private String correo;

    public Company toEntity() {
        return new Company(razon_social, rfc, telefono, contacto, correo);
    }
}
