package com.sagor.travel.controller;


import com.sagor.travel.entity.AddmissionLevel;
import com.sagor.travel.repo.AddmissionLevelRepo;
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
@RequestMapping(value = "/addmissionlevel/")
public class AddmissionLevelController {

        @Autowired
        private AddmissionLevelRepo addmissionLevelRepo;


        @GetMapping(value = "add")
        public String addShow(Model model) {
            model.addAttribute("addmission", new AddmissionLevel());

            return "addmissionlevel/add";

        }


        @PostMapping(value = "add")
        public String addmissionSave(@Valid AddmissionLevel addmissionLevel, BindingResult bindingResult, Model model) {
            if (bindingResult.hasErrors()) {
                return "addmissionlevel/add";
            } else {
                if (addmissionLevel != null) {
                    AddmissionLevel addmissionLevel1 = this.addmissionLevelRepo.findByName(addmissionLevel.getName());
                    if (addmissionLevel1 != null) {
                        model.addAttribute("exist", "Visatype allready exist");
                    } else {
                        this.addmissionLevelRepo.save(addmissionLevel);
                        model.addAttribute("addmission", new AddmissionLevel());
                        model.addAttribute("success", "Jobtype Add Successfully");
                    }

                }
            }


            return "addmissionlevel/add";
        }


        @GetMapping(value = "list")
        public String addmissionIndex(Model model) {
            model.addAttribute("addmissionlist", addmissionLevelRepo.findAll());
            return "addmissionlevel/list";
        }


        @GetMapping(value = "edit/{id}")
        public String editShow(Model model, @PathVariable("id") Long id) {
            model.addAttribute("addmissionlist", addmissionLevelRepo.findAll());

            return "addmissionlevel/edit";

        }


        @PostMapping(value = "edit/{id}")
        public String addmissionEdit(@Valid AddmissionLevel addmissionLevel, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
            if (bindingResult.hasErrors()) {
                return "addmissionlevel/edit";
            } else {
                if (addmissionLevel != null) {
                    AddmissionLevel addmissionLevel1 = this.addmissionLevelRepo.findByName(addmissionLevel.getName());
                    if (addmissionLevel1 != null) {
                        model.addAttribute("exist", "Visatype allready exist");

                    } else {

                        this.addmissionLevelRepo.save(addmissionLevel);
                        model.addAttribute("addmission", new AddmissionLevel());
                        model.addAttribute("success", "Jobtype Add Successfully");
                    }

                }
            }


            return "addmissionlevel/edit";
        }


        @GetMapping(value = "del/{id}")
        public String addmissiondel(@PathVariable("id") Long id) {
            if (id != null) {
                this.addmissionLevelRepo.deleteById(id);

            }
            return "redirect:/addmissionlevel/list";

        }
    }


