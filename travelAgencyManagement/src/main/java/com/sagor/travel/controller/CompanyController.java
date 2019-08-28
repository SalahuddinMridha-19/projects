package com.sagor.travel.controller;


import com.sagor.travel.entity.Company;
import com.sagor.travel.repo.CompanyRepo;
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
@RequestMapping(value ="/company/" )
public class CompanyController {

    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private CountryRepo countryRepo;

    @GetMapping(value = "add")
    public String addShow( Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("countrylist", this.countryRepo.findAll());

        return "company/add";

    }
    @PostMapping(value = "add")
    public String companySave(@Valid Company company, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("companylist", this.companyRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());

            return "company/add";
        }

        this.companyRepo.save(company);
        model.addAttribute("company", new Company());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("companylist", this.companyRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());

        return "company/add";
    }
    @GetMapping(value = "list")
    public String companyIndex(Model model) {
        model.addAttribute("companylist", this.companyRepo.findAll());
        return "company/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editShow(Model model,  @PathVariable("id") Long id) {
        model.addAttribute("companylist", this.companyRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());

        return "company/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String companyEdit(@Valid Company company, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("companylist", this.companyRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());
            return "company/edit";
        }
        company.setId(id);
        this.companyRepo.save(company);
        model.addAttribute("company", new Company());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("companylist", this.companyRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());

        return "company/edit";
    }
    @GetMapping(value = "/del/{id}")
    public String companydel(@PathVariable("id") Long id) {
        if (id != null) {
            this.companyRepo.deleteById(id);

        }
        return "redirect:/company/list";

    }
}
