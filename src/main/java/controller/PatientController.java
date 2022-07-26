package controller;

import dto.PatientCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PatientService;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/patients")
public class PatientController {

    private final PatientService service;

    @PostMapping
    protected void createPatient(@RequestBody PatientCreateDto body) {
        service.createPatient(body);
    }
}
