package com.sagor.travel.controller;

import com.sagor.travel.entity.JobType;
import com.sagor.travel.repo.JobTypeRepo;
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
@RequestMapping(value = "/jobtype/")
public class JobTypeController {

        @Autowired
        private JobTypeRepo jobTypeRepo;


        @GetMapping(value = "add")
        public String addShow(Model model) {
            model.addAttribute("jobtype", new JobType());

            return "jobtype/add";

        }


        @PostMapping(value = "add")
        public String jobSave(@Valid JobType jobType, BindingResult bindingResult, Model model) {
            if (bindingResult.hasErrors()) {
                return "jobtype/add";
            } else {
                if (jobType != null) {
                    JobType jobType1 = this.jobTypeRepo.findByName(jobType.getName());
                    if (jobType1 != null) {
                        model.addAttribute("exist", "Visatype allready exist");
                    } else {
                        this.jobTypeRepo.save(jobType);
                        model.addAttribute("jobtype", new JobType());
                        model.addAttribute("success", "Jobtype Add Successfully");
                    }

                }
            }


            return "jobtype/add";
        }


        @GetMapping(value = "list")
        public String jobIndex(Model model) {
            model.addAttribute("jobtypelist", jobTypeRepo.findAll());
            return "jobtype/list";
        }


        @GetMapping(value = "edit/{id}")
        public String editShow(Model model, @PathVariable("id") Long id) {
            model.addAttribute("jobtypelist", jobTypeRepo.findAll());

            return "jobtype/edit";

        }


        @PostMapping(value = "edit/{id}")
        public String jobEdit(@Valid JobType jobType, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
            if (bindingResult.hasErrors()) {
                return "jobtype/edit";
            } else {
                if (jobType != null) {
                    JobType jobType1 = this.jobTypeRepo.findByName(jobType.getName());
                    if (jobType1 != null) {
                        model.addAttribute("exist", "Visatype allready exist");

                    } else {

                        this.jobTypeRepo.save(jobType);
                        model.addAttribute("jobtype", new JobType());
                        model.addAttribute("success", "Jobtype Add Successfully");
                    }

                }
            }


            return "jobtype/edit";
        }


        @GetMapping(value = "del/{id}")
        public String jobdel(@PathVariable("id") Long id) {
            if (id != null) {
                this.jobTypeRepo.deleteById(id);

            }
            return "redirect:/jobtype/list";

        }
    }


