package mg.cdan4.tp.controller;

import mg.cdan4.tp.entity.Produit;
import mg.cdan4.tp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class ProduitController {
    @Autowired
    ProduitService produitService;

    @GetMapping("/")
    public String pageAccueil(Model model) {
        List<Produit> listProducts = produitService.listAll();
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @GetMapping("/new")
    public String nouveauProduit(Model model) {
        Produit produit = new Produit();
        model.addAttribute("produit", produit);
        return "new_produit";
    }

    @PostMapping(value = "/save")
    public String ajoutProduit(@ModelAttribute("product") Produit produit) {
        produitService.save(produit);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView afficheProduitEdit(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_produit");
        Produit produit = produitService.get(id);
        mav.addObject("produit", produit);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String supprimProduit(@PathVariable(name = "id") int id) {
        produitService.delete(id);
        return "redirect:/";
    }
}

