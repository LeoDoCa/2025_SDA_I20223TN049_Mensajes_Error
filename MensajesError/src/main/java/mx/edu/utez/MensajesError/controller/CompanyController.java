package mx.edu.utez.MensajesError.controller;

import jakarta.validation.Valid;
import mx.edu.utez.MensajesError.config.ApiResponse;
import mx.edu.utez.MensajesError.controller.dto.CompanyDto;
import mx.edu.utez.MensajesError.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll() {
        return service.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody CompanyDto dto) {
        System.out.println(dto);
        return service.save(dto.toEntity());
    }

    @PutMapping("/")
    public ResponseEntity<ApiResponse> update(@RequestBody CompanyDto dto) {
        return service.update(dto.toEntity());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ApiResponse> getByUuid(@PathVariable UUID uuid) { return service.findByUuid(uuid);}

    @DeleteMapping("/{uuid}")
    public ResponseEntity<ApiResponse> delete(@PathVariable UUID uuid){
        return service.delete(uuid);
    }
}
