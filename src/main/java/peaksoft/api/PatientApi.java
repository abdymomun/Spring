package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.service.PatientService;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientApi {
    private PatientService patientService;
}
