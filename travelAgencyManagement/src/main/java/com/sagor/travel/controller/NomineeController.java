package com.sagor.travel.controller;


import com.sagor.travel.entity.Nominee;
import com.sagor.travel.repo.ClientRepo;
import com.sagor.travel.repo.NomineeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/nominee/")
public class NomineeController {

    @Autowired
    private NomineeRepo nomineeRepo;
    @Autowired
    private ClientRepo clientRepo;

    @GetMapping(value = "add")
    public String addShow( Model model) {
        model.addAttribute("nominee",new Nominee());
        model.addAttribute("clientlist", this.clientRepo.findAll());

        return "nominee/add";

    }
    @PostMapping(value = "add")
    public String nomineeSave(@Valid Nominee nominee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("nomineelist", this.nomineeRepo.findAll());
            model.addAttribute("clientlist", this.clientRepo.findAll());

            return "nominee/add";
        }

        this.nomineeRepo.save(nominee);
        model.addAttribute("nominee", new Nominee());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("nomineelist", this.nomineeRepo.findAll());
        model.addAttribute("clientlist", this.clientRepo.findAll());
        return "nominee/add";
    }
    @GetMapping(value = "list")
    public String nomineeIndex(Model model) {
        model.addAttribute("nomineelist", this.nomineeRepo.findAll());
        return "nominee/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editShow(Model model,  @PathVariable("id") Long id) {
        model.addAttribute("nomineelist", this.nomineeRepo.findAll());
        model.addAttribute("clientlist", this.clientRepo.findAll());

        return "nominee/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String nomineeEdit(@Valid Nominee nominee, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("nomineelist", this.nomineeRepo.findAll());
            model.addAttribute("clientlist", this.clientRepo.findAll());
            return "nominee/edit";
        }
        nominee.setId(id);
        this.nomineeRepo.save(nominee);
        model.addAttribute("nominee", new Nominee());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("nomineelist", this.nomineeRepo.findAll());
        model.addAttribute("clientlist", this.clientRepo.findAll());

        return "nominee/edit";
    }
    @GetMapping(value = "/del/{id}")
    public String nomineedel(@PathVariable("id") Long id) {
        if (id != null) {
            this.nomineeRepo.deleteById(id);

        }
        return "redirect:/nominee/list";

    }
}
