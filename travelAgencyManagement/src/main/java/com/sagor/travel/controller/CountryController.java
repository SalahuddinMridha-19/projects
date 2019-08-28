package com.sagor.travel.controller;


import com.sagor.travel.entity.Country;

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
@RequestMapping(value = "/country/")
public class CountryController {

    @Autowired
    private CountryRepo countryRepo;


    @GetMapping(value = "add")
    public String addShow(Country country) {
        return "country/add";

    }


    @PostMapping(value = "add")
    public String countrySave(@Valid Country country, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "country/add";
        } else {
            if (country != null) {
                Country country1 = this.countryRepo.findByName(country.getName());
                if (country1 != null) {
                    model.addAttribute("exist", "Category allready exist");

                } else {
//
                    this.countryRepo.save(country);
                    model.addAttribute("country", new Country());
                    model.addAttribute("success", "Category Add Successfully");
                }

            }
        }


        return "country/add";
    }


    @GetMapping(value = "list")
    public String countryIndex(Model model) {
        model.addAttribute("countrylist", countryRepo.findAll());
        return "country/list";
    }


    @GetMapping(value = "edit/{id}")
    public String editShow(Model model, @PathVariable("id") Long id) {
        model.addAttribute("country", this.countryRepo.getOne(id));
        return "country/edit";

    }


    @PostMapping(value = "edit/{id}")
    public String countryEdit(@Valid Country country, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "country/edit";
        } else {
            if (country != null) {
                Country country1 = this.countryRepo.findByName(country.getName());
                if (country1 != null) {
                    model.addAttribute("exist", "Category allready exist");

                } else {
//
                    country.setId(id);
                    this.countryRepo.save(country);
                    model.addAttribute("country", new Country());
                    model.addAttribute("success", "Country Add Successfully");
                }

            }
        }


        return "country/edit";
    }


    @GetMapping(value = "del/{id}")
    public String countrydel(@PathVariable("id") Long id) {
        if (id != null) {
            this.countryRepo.deleteById(id);

        }
        return "redirect:/country/list";

    }
    }

