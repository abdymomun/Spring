package peaksoft.api;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Department;
import peaksoft.service.DepartmentService;

@Controller
@RequestMapping("/department/{hospitalId}")
@RequiredArgsConstructor
public class DepartmentApi {
    private final DepartmentService departmentService;

    @GetMapping
    public String getAllDepartments(@PathVariable Long hospitalId, Model model) {
        model.addAttribute("allDepartments", departmentService.getAllDepartment(hospitalId));
        model.addAttribute("hospitalIds",hospitalId);
        return "department";
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@PathVariable Long hospitalId, @ModelAttribute("newDepartment") Department department) {
        departmentService.save(department, hospitalId);
        return "redirect:/hospital";}

    @GetMapping("/getDepartment/{departmentId}")
    public String getDepartmentDetails(@PathVariable("departmentId") Long departmentId,
                                       @PathVariable Long hospitalId, Model model) {
        model.addAttribute("departmentDetails", departmentService.getDepartmentById(departmentId));
        model.addAttribute("hospitalID",hospitalId);
        model.addAttribute("departmentId",departmentId);
        return "departmentOne";}

    @GetMapping("/{departmentId}/update")
    public String createDepartment(@PathVariable(name = "hospitalId") Long hospitalId,
                                   @PathVariable(name = "departmentId") Long departmentId, Model model) {
        model.addAttribute("updateDepartment", departmentService.getDepartmentById(departmentId));
        model.addAttribute("hospitalId", hospitalId);
        return "updateDepartment";
    }

    @PostMapping("/saveDepart/{departmentId}")
    public String saveUpdate(@PathVariable("hospitalId") Long hospitalId,
                             @PathVariable("departmentId") Long departmentId,
                             @ModelAttribute("updateDepartment") Department department) {
        departmentService.updateDepartmentById(departmentId, department);
        return "redirect:/department/"+hospitalId;
    }

@DeleteMapping("{departmentId}/delete")
public String deleteDepartment(@PathVariable("departmentId") Long departmentId, @PathVariable Long hospitalId) {
    departmentService.deleteDepartmentById(departmentId);
    return "redirect:/department/"+hospitalId;
}


}

