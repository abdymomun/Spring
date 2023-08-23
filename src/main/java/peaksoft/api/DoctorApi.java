package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Doctor;
import peaksoft.service.DoctorService;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorApi {
    private final DoctorService doctorService;

    @GetMapping("/{hospitalId}/{departmentId}")
    public String getAllDoctor(@PathVariable Long hospitalId,
                               @PathVariable Long departmentId, Model model) {
        model.addAttribute("allDoctors", doctorService.getAllDoctors(hospitalId));
        model.addAttribute("departmentId", departmentId);
        return "doctor";
    }


    @GetMapping("/{hospitalId}/{departmentId}/newDoc")
    public String creatDoctor(@PathVariable Long hospitalId, @PathVariable Long departmentId, Model model) {
        Doctor newDoctor = new Doctor();
        model.addAttribute("newDoctor", newDoctor);
        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("departmentId", departmentId);

        return "newDoctor";
    }


    @PostMapping("/{hospitalId}/{departmentId}/saveDoctor")
    public String saveDoctor(@PathVariable Long hospitalId, @PathVariable Long departmentId, @ModelAttribute("newDoctor") Doctor doctor) {
        doctorService.saveDoctor(doctor, hospitalId, departmentId);
        return "redirect:/doctor/" + hospitalId + "/" + departmentId;
    }


//    @GetMapping("/getDepartment/{departmentId}")
//    public String getDepartmentDetails(@PathVariable("departmentId") Long departmentId,
//                                       @PathVariable Long hospitalId, Model model) {
//        model.addAttribute("departmentDetails", departmentService.getDepartmentById(departmentId));
//        model.addAttribute("hospitalID",hospitalId);
//        model.addAttribute("departmentId",departmentId);
//        return "departmentOne";}

    @GetMapping("/getDoctor/{hospitalId}/{departmentId}/{doctorId}")
    public String getById(@PathVariable Long hospitalId, @PathVariable Long departmentId, @PathVariable Long doctorId, Model model) {
        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("departmentId", departmentId);
        model.addAttribute("doctorOne", doctorService.getDoctorById(doctorId));
        return "doctorOne";
    }


    @GetMapping("updateDoc/{hospitalId}/{departmentId}/{doctorId}")
    public String updateDoctor(@PathVariable Long hospitalId, @PathVariable Long departmentId,@PathVariable Long doctorId,Model model){
        model.addAttribute("hospitalId",hospitalId);
        model.addAttribute("departmentId",departmentId);
        model.addAttribute("updateDoctor",doctorService.getDoctorById(doctorId));
        return "updateDoctor";
    }

    @PostMapping("/{hospitalId}/{departmentId}/{doctorId}/saveUpdate")
    public String saveUpdate(@PathVariable Long hospitalId,
                             @PathVariable Long departmentId,
                             @PathVariable Long doctorId,
                             @ModelAttribute("updateDoctor") Doctor doctor){
doctorService.updateDoctorById(doctorId,doctor);
        return "redirect:/doctor/" + hospitalId + "/" + departmentId;
    }


//    @DeleteMapping("{departmentId}/delete")
//    public String deleteDepartment(@PathVariable("departmentId") Long departmentId, @PathVariable Long hospitalId) {
//        departmentService.deleteDepartmentById(departmentId);
//        return "redirect:/department/"+hospitalId;
//    }
    @DeleteMapping("/{hospitalId}/{departmentId}/{doctorId}/delete")
public String deleteDoctor(@PathVariable Long hospitalId,
                           @PathVariable Long departmentId,
                           @PathVariable Long doctorId){
        doctorService.deleteDoctorById(doctorId);
        return "redirect:/doctor/"+ hospitalId + "/" +departmentId;
    }


}
