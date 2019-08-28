package com.sagor.travel.controller;


import com.sagor.travel.entity.University;
import com.sagor.travel.repo.CountryRepo;
import com.sagor.travel.repo.UniversityRepo;
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
@RequestMapping(value ="/university" )
public class UniversityController {

    @Autowired
    private UniversityRepo universityRepo;

    @Autowired
    private CountryRepo countryRepo;

    @GetMapping(value = "/add")
    public String addShow( Model model) {
        model.addAttribute("university", new University());
        model.addAttribute("countrylist", this.countryRepo.findAll());

        return "university/add";

    }
    @PostMapping(value = "/add")
    public String universitySave(@Valid University university, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("universitylist", this.universityRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());

            return "university/add";
        }

        this.universityRepo.save(university);
        model.addAttribute("university", new University());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("universitylist", this.universityRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());

        return "university/add";
    }
    @GetMapping(value = "/list")
    public String universityIndex(Model model) {
        model.addAttribute("universitylist", this.universityRepo.findAll());
        return "university/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editShow(Model model,  @PathVariable("id") Long id) {
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("university", this.universityRepo.getOne(id));

        return "university/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String universityEdit(@Valid University universiry, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("universitylist", this.universityRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());

            return "university/edit";
        }
        universiry.setId(id);
        this.universityRepo.save(universiry);
        model.addAttribute("university", new University());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("universitylist", this.universityRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());

        return "university/edit";
    }
    @GetMapping(value = "/del/{id}")
    public String universitydel(@PathVariable("id") Long id) {
        if (id != null) {
            this.universityRepo.deleteById(id);

        }
        return "redirect:/university/list";

    }
}
