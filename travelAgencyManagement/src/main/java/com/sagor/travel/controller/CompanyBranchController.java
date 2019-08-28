package com.sagor.travel.controller;





import com.sagor.travel.entity.CompanyBranch;
import com.sagor.travel.repo.CompanyBranchRepo;
import com.sagor.travel.repo.CompanyRepo;
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
@RequestMapping(value = "/companybranch/")
public class CompanyBranchController {
    @Autowired
    private CompanyBranchRepo companyBranchRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @GetMapping(value = "add")
    public String addShow(Model model) {
        model.addAttribute("companybranch", new CompanyBranch());
        model.addAttribute("companylist", this.companyRepo.findAll());

        return "companybranch/add";

    }
    @PostMapping(value = "add")
    public String branchSave(@Valid CompanyBranch companyBranch, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("branchlist", this.companyBranchRepo.findAll());
            model.addAttribute("companylist", this.companyRepo.findAll());
            return "companybranch/add";
        }

        this.companyBranchRepo.save(companyBranch);
        model.addAttribute("companybranch", new CompanyBranch());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("branchlist", this.companyBranchRepo.findAll());
        model.addAttribute("companylist", this.companyRepo.findAll());

        return "companybranch/add";
    }
    @GetMapping(value = "list")
    public String branchIndex(Model model) {
        model.addAttribute("companybranchlist", this.companyBranchRepo.findAll());
        return "companybranch/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editShow(Model model,  @PathVariable("id") Long id) {
        model.addAttribute("branchlist", this.companyBranchRepo.findAll());
        model.addAttribute("companylist", this.companyRepo.findAll());
        return "companybranch/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String agencyEdit(@Valid CompanyBranch companyBranch, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("branchlist", this.companyBranchRepo.findAll());
            model.addAttribute("companylist", this.companyRepo.findAll());

            return "companybranch/edit";
        }
        companyBranch.setId(id);
        this.companyBranchRepo.save(companyBranch);
        model.addAttribute("companybranch", new CompanyBranch());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("branchlist", this.companyBranchRepo.findAll());
        model.addAttribute("companylist", this.companyRepo.findAll());
        return "companybranch/edit";
    }
    @GetMapping(value = "/del/{id}")
    public String agencydel(@PathVariable("id") Long id) {
        if (id != null) {
            this.companyBranchRepo.deleteById(id);

        }
        return "redirect:/companybranch/list";

    }

}
