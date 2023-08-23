package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Hospital;
import peaksoft.service.HospitalService;

@Controller
@RequestMapping("/hospital")
@RequiredArgsConstructor

public class HospitalApi {
    private final HospitalService hospitalService;

    @GetMapping
    public String getAllHospitals(Model model) {
        model.addAttribute("hospitals", hospitalService.getAllHospitals());
        return "getAll";
    }

    @GetMapping("/new")
    public String createHospital(Model model) {
        model.addAttribute("newHospital", new Hospital());
        return "newHospital";
    }

    @PostMapping
    public String saveHospital(@ModelAttribute("newHospital") Hospital hospital) {
        hospitalService.saveHospital(hospital);
        return "redirect:/hospital";
    }
    @DeleteMapping("{hospitalId}/delete")
    public String deleteHospital(@PathVariable("hospitalId") Long id) {
        hospitalService.deleteHospital(id);
        return "redirect:/hospital";
    }
    @GetMapping("{hospitalId}/update")
public String update(@PathVariable("hospitalId")Long hospitalId,Model model){
        model.addAttribute("updateHospital" ,hospitalService.getHospitalById(hospitalId));
        return "update";
    }

    @PostMapping("{hospitalId}/saveHospital")
    public String saveUpdate(@PathVariable("hospitalId")Long hospitalId,@ModelAttribute("updateHospital")Hospital hospital){
        hospitalService.updateHospital(hospitalId,hospital);
        return "redirect:/hospital";
    }
    @GetMapping("{hospitalId}/hospital")
    public String getHospitalDetails(@PathVariable("hospitalId") Long hospitalId, Model model) {
        model.addAttribute("hospitalDetails", hospitalService.getHospitalById(hospitalId));
        return "hospitalOne";
    }


}