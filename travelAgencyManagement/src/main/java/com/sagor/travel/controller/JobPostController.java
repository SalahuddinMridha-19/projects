package com.sagor.travel.controller;


import com.sagor.travel.entity.JobPost;
import com.sagor.travel.repo.JobPostRepo;
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
@RequestMapping(value = "/jobpost/")
public class JobPostController {

        @Autowired
        private JobPostRepo jobPostRepo;


        @GetMapping(value = "add")
        public String addShow(Model model) {
            model.addAttribute("jobpost", new JobPost());

            return "jobpost/add";

        }


        @PostMapping(value = "add")
        public String jobSave(@Valid JobPost jobPost, BindingResult bindingResult, Model model) {
            if (bindingResult.hasErrors()) {
                return "jobpost/add";
            } else {
                if (jobPost != null) {
                    JobPost jobPost1 = this.jobPostRepo.findByName(jobPost.getName());
                    if (jobPost1 != null) {
                        model.addAttribute("exist", "Visatype allready exist");

                    } else {

                        this.jobPostRepo.save(jobPost);
                        model.addAttribute("jobpost", new JobPost());
                        model.addAttribute("success", "Jobtype Add Successfully");
                    }

                }
            }


            return "jobpost/add";
        }


        @GetMapping(value = "list")
        public String jobIndex(Model model) {
            model.addAttribute("jobPostlist", jobPostRepo.findAll());
            return "jobpost/list";
        }


        @GetMapping(value = "edit/{id}")
        public String editShow(Model model, @PathVariable("id") Long id) {
            model.addAttribute("jobPostlist", jobPostRepo.findAll());

            return "jobpost/edit";

        }


        @PostMapping(value = "edit/{id}")
        public String jobEdit(@Valid JobPost jobPost, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
            if (bindingResult.hasErrors()) {
                return "jobpost/add";
            } else {
                if (jobPost != null) {
                    JobPost jobPost1 = this.jobPostRepo.findByName(jobPost.getName());
                    if (jobPost1 != null) {
                        model.addAttribute("exist", "Visatype allready exist");

                    } else {

                        this.jobPostRepo.save(jobPost);
                        model.addAttribute("jobpost", new JobPost());
                        model.addAttribute("success", "Jobtype Add Successfully");
                    }

                }
            }


            return "jobpost/edit";
        }


        @GetMapping(value = "del/{id}")
        public String jobdel(@PathVariable("id") Long id) {
            if (id != null) {
                this.jobPostRepo.deleteById(id);

            }
            return "redirect:/jobpost/list";

        }
    }


