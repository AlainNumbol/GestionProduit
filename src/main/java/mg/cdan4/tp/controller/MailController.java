package mg.cdan4.tp.controller;

import mg.cdan4.tp.entity.MailEntity;
import mg.cdan4.tp.service.NotificationService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mail")
public class MailController {

    @GetMapping("/show/")
    public String afficheMail( Model model){
        MailEntity mail = new MailEntity();
        model.addAttribute("mail",mail);
        return "sendMail";
    }

    @PostMapping("/send")
    public String sendMail(@ModelAttribute("mail") MailEntity mailEntity){
        NotificationService notificationRefuser = new NotificationService();
        notificationRefuser.sendMailTo(mailEntity.getMailadresse(),
                mailEntity.getSubject(),
                mailEntity.getContenue());
        return "redirect:/";
    }

    public int somme(int a, int b){
        return a+b;
    }

    public int diff(int a, int b) {
        int res =a-b;
        return a-b;
    }
}
