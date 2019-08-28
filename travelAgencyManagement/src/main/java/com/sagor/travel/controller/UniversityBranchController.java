package com.sagor.travel.controller;


import com.sagor.travel.entity.UniversityBranch;
import com.sagor.travel.repo.UniversityBranchRepo;
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
@RequestMapping(value = "/universitybranch/")
public class UniversityBranchController {
    @Autowired
    private UniversityBranchRepo universityBranchRepo;

    @Autowired
    private UniversityRepo universityRepo;

    @GetMapping(value = "add")
    public String addShow( Model model) {
        model.addAttribute("universitybranch", new UniversityBranch());
        model.addAttribute("universirylist", this.universityRepo.findAll());

        return "universitybranch/add";

    }
    @PostMapping(value = "add")
    public String branchSave(@Valid UniversityBranch universityBranch, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("universitybranchlist", this.universityBranchRepo.findAll());
            model.addAttribute("universirylist", this.universityRepo.findAll());

            return "universitybranch/add";
        }

        this.universityBranchRepo.save(universityBranch);
        model.addAttribute("universitybranch", new UniversityBranch());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("universitybranchlist", this.universityBranchRepo.findAll());
        model.addAttribute("universirylist", this.universityRepo.findAll());


        return "universitybranch/add";
    }
    @GetMapping(value = "list")
    public String branchIndex(Model model) {
        model.addAttribute("universitybranchlist", this.universityBranchRepo.findAll());
        return "universitybranch/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editShow(Model model,  @PathVariable("id") Long id) {
        model.addAttribute("universitybranchlist", this.universityBranchRepo.findAll());
        model.addAttribute("universirylist", this.universityRepo.findAll());


        return "universitybranch/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String agencyEdit(@Valid UniversityBranch universityBranch, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("universitybranchlist", this.universityBranchRepo.findAll());
            model.addAttribute("universirylist", this.universityRepo.findAll());


            return "universitybranch/edit";
        }
        universityBranch.setId(id);
        this.universityBranchRepo.save(universityBranch);
        model.addAttribute("universitybranch", new UniversityBranch());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("universitybranchlist", this.universityBranchRepo.findAll());
        model.addAttribute("universirylist", this.universityRepo.findAll());


        return "universitybranch/edit";
    }
    @GetMapping(value = "/del/{id}")
    public String agencydel(@PathVariable("id") Long id) {
        if (id != null) {
            this.universityBranchRepo.deleteById(id);

        }
        return "redirect:/universitybranch/list";

    }

}
