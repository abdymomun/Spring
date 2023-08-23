package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Appointment;
import peaksoft.service.AppointmentService;

@Controller
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentApi {
    private final AppointmentService appointmentService;
    @GetMapping
    public String getAllApointment(@PathVariable Long hospitalId, Model model){
        model.addAttribute("hospitalId",hospitalId);
        model.addAttribute("allApointment",appointmentService.getAllAppointment(hospitalId));
        return "appointment";
    }
    @GetMapping("/{hospitalId}/{doctorId}newApointment")
    public String createApointment(@PathVariable Long hospitalId, Model model, @PathVariable Long doctorId){
        model.addAttribute("hospitalId",hospitalId);
        model.addAttribute("doctorId",doctorId);
        model.addAttribute("newApointment",new Appointment());
        return "newApointment";
    }

    @PostMapping("/{hospitalId}/{doctorId}/saveApointment")
    public String saveApointment(@PathVariable Long hospitalId, @ModelAttribute("newApointment") Appointment appointment, @PathVariable Long doctorId){
        appointmentService.saveAppointment(appointment,hospitalId,doctorId);
return "redirect:/appointment";
    }
}
