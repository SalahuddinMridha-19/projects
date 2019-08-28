package com.sagor.travel.controller;

import com.sagor.travel.entity.Visatype;
import com.sagor.travel.repo.VisaTypeRepo;
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
@RequestMapping(value = "/visatype/")
public class VisaTypeController {

        @Autowired
        private VisaTypeRepo visaTypeRepo;


        @GetMapping(value = "add")
        public String addShow(Model model) {
            model.addAttribute("type", new Visatype());

            return "visatype/add";

        }


        @PostMapping(value = "add")
        public String visatypeSave(@Valid Visatype visatype, BindingResult bindingResult, Model model) {
            if (bindingResult.hasErrors()) {
                return "visatype/add";
            } else {
                if (visatype != null) {
                    Visatype visatype1 = this.visaTypeRepo.findByTypeName(visatype.getTypeName());
                    if (visatype1 != null) {
                        model.addAttribute("exist", "Visatype allready exist");

                    } else {

                        this.visaTypeRepo.save(visatype);
                        model.addAttribute("type", new Visatype());
                        model.addAttribute("success", "Visatype Add Successfully");
                    }

                }
            }


            return "visatype/add";
        }


        @GetMapping(value = "list")
        public String visatypeIndex(Model model) {
            model.addAttribute("typelist", visaTypeRepo.findAll());
            return "visatype/list";
        }


        @GetMapping(value = "edit/{id}")
        public String editShow(Model model, @PathVariable("id") Long id) {
            model.addAttribute("type", this.visaTypeRepo.getOne(id));

            return "visatype/edit";

        }


        @PostMapping(value = "edit/{id}")
        public String visatypeEdit(@Valid Visatype visatype, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
            if (bindingResult.hasErrors()) {
                return "visatype/edit";
            } else {
                if (visatype != null) {
                    Visatype visatype1 = this.visaTypeRepo.findByTypeName(visatype.getTypeName());
                    if (visatype1 != null) {
                        model.addAttribute("exist", "Visatype allready exist");
                        model.addAttribute("type", new Visatype());
                    } else {
                        visatype.setTypeId(id);
                        this.visaTypeRepo.save(visatype);
                        model.addAttribute("type", new Visatype());
                        model.addAttribute("success", "Visatype Add Successfully");
                    }

                }
            }


            return "visatype/edit";
        }


        @GetMapping(value = "del/{id}")
        public String visadel(@PathVariable("id") Long id) {
            if (id != null) {
                this.visaTypeRepo.deleteById(id);

            }
            return "redirect:/type/list";

        }
    }


