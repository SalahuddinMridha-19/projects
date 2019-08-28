package com.sagor.travel.controller;


import com.sagor.travel.entity.StudentPackage;
import com.sagor.travel.entity.StudentSummary;
import com.sagor.travel.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "/studentpackage/")
public class StudentPackageController {
    @Autowired
    private StudentPackageRepo studentPackageRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private VisaTypeRepo visaTypeRepo;

    @Autowired
    private UniversityRepo universityRepo;

    @Autowired
    private UniversityBranchRepo universityBranchRepo;

    @Autowired
    private AddmissionLevelRepo addmissionLevelRepo;

    @Autowired
    private StudentSummaryRepo studentSummaryRepo;

    @GetMapping(value = "add")
    public String addShow( Model model) {
        model.addAttribute("stupackage", new StudentPackage());
        model.addAttribute("clientlist", this.clientRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("visatypelist", this.visaTypeRepo.findAll());
        model.addAttribute("universitylist", this.universityRepo.findAll());
        model.addAttribute("universitybranchlist", this.universityBranchRepo.findAll());
        model.addAttribute("levellist", this.addmissionLevelRepo.findAll());
        return "studentpackage/add";
    }
    @PostMapping(value = "add")
    public String stuSave(@Valid  StudentPackage studentPackage, BindingResult bindingResult, Model model) {
        studentPackage.setPaymentDate(new Date());
        if (bindingResult.hasErrors()) {
            model.addAttribute("studentlist", this.studentPackageRepo.findAll());
            model.addAttribute("clientlist", this.clientRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());
            model.addAttribute("visatypelist", this.visaTypeRepo.findAll());
            model.addAttribute("universitylist", this.universityRepo.findAll());
            model.addAttribute("universitybranchlist", this.universityBranchRepo.findAll());
            model.addAttribute("levellist", this.addmissionLevelRepo.findAll());
            return "studentpackage/add";
        }




        this.studentPackageRepo.save(studentPackage);

        //Save Student Summary Package

        StudentSummary tm=new StudentSummary();
        tm.setClient(clientRepo.findByEmail(studentPackage.getClient().getEmail()).get());
        tm.setPayableAmount(studentPackage.getAmount());
        tm.setPaymentAmount(studentPackage.getPaymentAmount());
        double due = studentPackage.getAmount() - studentPackage.getPaymentAmount();
        tm.setDueAmount(due);
        tm.setTransDate(new Date());
        this.studentSummaryRepo.save(tm);

        model.addAttribute("stupackage", new StudentPackage());
        model.addAttribute("success", "Congratulations! Data save sucessfully");

        model.addAttribute("clientlist", this.clientRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("visatypelist", this.visaTypeRepo.findAll());
        model.addAttribute("universitylist", this.universityRepo.findAll());
        model.addAttribute("universitybranchlist", this.universityBranchRepo.findAll());
        model.addAttribute("levellist", this.addmissionLevelRepo.findAll());

        return "studentpackage/add";
    }
    @GetMapping(value = "list")
    public String stuIndex(Model model) {
        model.addAttribute("stulist", this.studentPackageRepo.findAll());
        return "studentpackage/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editShow(Model model,  @PathVariable("id") Long id) {
        model.addAttribute("studentlist", this.studentPackageRepo.findAll());
        model.addAttribute("clientlist", this.clientRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("visatypelist", this.visaTypeRepo.findAll());
        model.addAttribute("universitylist", this.universityRepo.findAll());
        model.addAttribute("universitybranchlist", this.universityBranchRepo.findAll());
        model.addAttribute("levellist", this.addmissionLevelRepo.findAll());


        return "studentpackage/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String stuEdit(@Valid StudentPackage studentPackage, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("studentlist", this.studentPackageRepo.findAll());
            model.addAttribute("clientlist", this.clientRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());
            model.addAttribute("visatypelist", this.visaTypeRepo.findAll());
            model.addAttribute("universitylist", this.universityRepo.findAll());
            model.addAttribute("universitybranchlist", this.universityBranchRepo.findAll());
            model.addAttribute("levellist", this.addmissionLevelRepo.findAll());

            return "studentpackage/edit";
        }
        studentPackage.setId(id);
        this.studentPackageRepo.save(studentPackage);
        model.addAttribute("stupackage", new StudentPackage());
        model.addAttribute("success", "Congratulations! Data save sucessfully");

        model.addAttribute("clientlist", this.clientRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("visatypelist", this.visaTypeRepo.findAll());
        model.addAttribute("universitylist", this.universityRepo.findAll());
        model.addAttribute("universitybranchlist", this.universityBranchRepo.findAll());
        model.addAttribute("levellist", this.addmissionLevelRepo.findAll());

        return "studentpackage/edit";
    }
    @GetMapping(value = "/del/{id}")
    public String studel(@PathVariable("id") Long id) {
        if (id != null) {
            this.studentPackageRepo.deleteById(id);
        }
        return "redirect:/studentpackage/list";
    }

}
