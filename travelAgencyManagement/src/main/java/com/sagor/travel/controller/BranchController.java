package com.sagor.travel.controller;


import com.sagor.travel.entity.Branch;
import com.sagor.travel.repo.AgencyRepo;

import com.sagor.travel.repo.BranchRepo;
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
@RequestMapping(value = "/branch/")
public class BranchController {
    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private AgencyRepo agencyRepo;

    @GetMapping(value = "add")
    public String addShow(Model model) {
        model.addAttribute("branch", new Branch());
        model.addAttribute("branchlist", this.branchRepo.findAll());

        return "branch/add";

    }
    @PostMapping(value = "add")
    public String branchSave(@Valid Branch branch, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("agencylist", this.agencyRepo.findAll());
            model.addAttribute("branchlist", this.branchRepo.findAll());

            return "branch/add";
        }

        this.branchRepo.save(branch);
        model.addAttribute("branch", new Branch());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("agencylist", this.agencyRepo.findAll());
        model.addAttribute("branchlist", this.branchRepo.findAll());

        return "branch/add";
    }
    @GetMapping(value = "list")
    public String branchIndex(Model model) {
        model.addAttribute("branchlist", this.branchRepo.findAll());
        return "branch/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editShow(Model model,  @PathVariable("id") Long id) {
        model.addAttribute("branchlist", this.branchRepo.findAll());
        model.addAttribute("agencylist", this.agencyRepo.getOne(id));

        return "branch/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String agencyEdit(@Valid Branch branch, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("agencylist", this.agencyRepo.findAll());
            model.addAttribute("branchlist", this.branchRepo.findAll());

            return "branch/edit";
        }
        branch.setId(id);
        this.branchRepo.save(branch);
        model.addAttribute("branch", new Branch());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("agencylist", this.agencyRepo.findAll());
        model.addAttribute("branchlist", this.branchRepo.findAll());

        return "branch/edit";
    }
    @GetMapping(value = "/del/{id}")
    public String agencydel(@PathVariable("id") Long id) {
        if (id != null) {
            this.branchRepo.deleteById(id);

        }
        return "redirect:/branch/list";

    }

}
