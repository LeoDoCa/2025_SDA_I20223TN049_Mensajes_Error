package mx.edu.utez.PracticaMensajesError.service.company;

import mx.edu.utez.PracticaMensajesError.config.ApiResponse;
import mx.edu.utez.PracticaMensajesError.models.CompanyBean;
import mx.edu.utez.PracticaMensajesError.models.CompanyRepository;
import mx.edu.utez.PracticaMensajesError.models.dto.CompanyDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class CompanyService {
    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAll() {
        return new ResponseEntity<>(
                new ApiResponse(repository.findAll(), HttpStatus.OK),
                HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id){
        return new ResponseEntity<>(
                new ApiResponse(repository.findById(id), HttpStatus.OK),
                HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> save(CompanyBean company) {
        company = repository.saveAndFlush(company);
        return new ResponseEntity<>(new ApiResponse(company, HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> update(CompanyBean company) {
        company = repository.saveAndFlush(company);
        return new ResponseEntity<>(new ApiResponse(company, HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public void delete(CompanyBean companyBean) {
        repository.delete(companyBean);
    }
}
