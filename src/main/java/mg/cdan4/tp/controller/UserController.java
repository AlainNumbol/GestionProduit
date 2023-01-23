package mg.cdan4.tp.controller;

import mg.cdan4.tp.entity.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/register")
    public String afficheForm(Model model) {
        Utilisateur user = new Utilisateur();
        model.addAttribute("user", user);

        List<String> listProfession = Arrays.asList("Développeur", "Testeur", "Concepteur");
        model.addAttribute("listProfession", listProfession);

        return "register_form";
    }

    @PostMapping("/register")
    public String soumettreForm(@Valid @ModelAttribute("user") Utilisateur user,
                                BindingResult bindingResult, Model model) {
        System.out.println(user);
        if (bindingResult.hasErrors()) {
            List<String> listProfession = Arrays.asList("Développeur", "Testeur", "Concepteur");
            model.addAttribute("listProfession", listProfession);
            return "register_form";
        } else {
            return "register_success";
        }
    }
}
