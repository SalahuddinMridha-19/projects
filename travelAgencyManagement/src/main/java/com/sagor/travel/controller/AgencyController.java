package com.sagor.travel.controller;

import com.sagor.travel.entity.Agency;
import com.sagor.travel.repo.AgencyRepo;
import com.sagor.travel.repo.CountryRepo;
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
@RequestMapping(value = "/agency")
public class AgencyController {
    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private AgencyRepo agencyRepo;

    @GetMapping(value = "/add")
    public String addShow(Model model) {
        model.addAttribute("agences", new Agency());
        model.addAttribute("countrylist", this.countryRepo.findAll());

        return "agency/add";

    }
    @PostMapping(value = "/add")
    public String agencySave(@Valid Agency agency, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("agencylist", this.agencyRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());

            return "agency/add";
        }

        this.agencyRepo.save(agency);
        model.addAttribute("agences", new Agency());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("agencylist", this.agencyRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());

        return "agency/add";
    }
    @GetMapping(value = "/list")
    public String agencyIndex(Model model) {
        model.addAttribute("agencylists", this.agencyRepo.findAll());
        return "agency/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editShow(Model model,  @PathVariable("id") Long id) {
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("agences", this.agencyRepo.getOne(id));

        return "agency/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String agencyEdit(@Valid Agency agency, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("agencylist", this.agencyRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());

            return "agency/edit";
        }
        agency.setId(id);
        this.agencyRepo.save(agency);
        model.addAttribute("agences", new Agency());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("agencylist", this.agencyRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());

        return "agency/edit";
    }
    @GetMapping(value = "/del/{id}")
    public String agencydel(@PathVariable("id") Long id) {
        if (id != null) {
            this.agencyRepo.deleteById(id);

        }
        return "redirect:/agency/list";

    }

}
