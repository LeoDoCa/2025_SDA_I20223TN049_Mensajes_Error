package mx.edu.utez.PracticaMensajesError.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CompanyBean {

    public CompanyBean(int id, String razonSocial, String rfc, String telefono, String contacto, String correo) {
    }

    @Entity
    @Table(name = "company")
    @NoArgsConstructor
    @Setter
    @Getter
    @Builder
    public class Company {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(length = 100, nullable = false)
        private String razonSocial;
        @Column(length = 12, nullable = false, unique = true)
        private String rfc;
        @Column(length = 14, nullable = false)
        private String telefono;
        @Column(length = 100, nullable = false)
        private String contacto;
        @Column(length = 320, nullable = false)
        private String correo;

        public Company(Long id, String razonSocial, String rfc, String telefono, String contacto, String correo) {
            this.id = id;
            this.razonSocial = razonSocial;
            this.rfc = rfc;
            this.telefono = telefono;
            this.contacto = contacto;
            this.correo = correo;
        }
    }
}
