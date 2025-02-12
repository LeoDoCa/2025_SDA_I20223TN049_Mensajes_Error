package mx.edu.utez.PracticaMensajesError.models.dto;

import jakarta.persistence.Column;
import lombok.*;
import mx.edu.utez.PracticaMensajesError.models.CompanyBean;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {
    private int id;
    private String razonSocial;
    private String rfc;
    private String telefono;
    private String contacto;
    private String correo;

    public CompanyBean toEntity() {
        return new CompanyBean(id, razonSocial, rfc, telefono, contacto, correo);
    }
}
