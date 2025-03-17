package ma.enset.hopital.web;

import lombok.AllArgsConstructor;
import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public String index(Model model,
                        @RequestParam(name="page", defaultValue="0") int page,
                        @RequestParam(name="size", defaultValue="4") int size,
                        @RequestParam(name="keyword", defaultValue="") String keyword) {
        Page<Patient> pagePatients = patientRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("patients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        return "patients";
    }

    @GetMapping(path = "/deletePatient")
    public String delete(@RequestParam Long id) {
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }
}