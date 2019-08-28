package com.sagor.travel.controller;

import com.sagor.travel.entity.JobPackage;
import com.sagor.travel.entity.JobTransactionSummary;
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
@RequestMapping(value = "/jobpackage/")
public class JobPackageController {
    @Autowired
    private JobPackageRepo jobPackageRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private VisaTypeRepo visaTypeRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private CompanyBranchRepo companyBranchRepo;

    @Autowired
    private JobTypeRepo jobTypeRepo;

    @Autowired
    private JobPostRepo jobPostRepo;

    @Autowired
    private JobTransactionSummaryRepo jobTransactionSummaryRepo;


    @GetMapping(value = "add")
    public String addShow( Model model) {
        model.addAttribute("jobpackage", new JobPackage());
        model.addAttribute("clientlist", this.clientRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("visatypelist", this.visaTypeRepo.findAll());
        model.addAttribute("companylist", this.companyRepo.findAll());
        model.addAttribute("companybranchlist", this.companyBranchRepo.findAll());
        model.addAttribute("typelist", this.jobTypeRepo.findAll());
        model.addAttribute("postlist", this.jobPostRepo.findAll());

        return "jobpackage/add";

    }
    @PostMapping(value = "add")
    public String jobSave(@Valid JobPackage jobPackage, BindingResult bindingResult, Model model) {
        jobPackage.setPaymentDate(new Date());
        if (bindingResult.hasErrors()) {
            model.addAttribute("joblist", this.jobPackageRepo.findAll());
            model.addAttribute("clientlist", this.clientRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());
            model.addAttribute("visatypelist", this.visaTypeRepo.findAll());
            model.addAttribute("companylist", this.companyRepo.findAll());
            model.addAttribute("companybranchlist", this.companyBranchRepo.findAll());
            model.addAttribute("typelist", this.jobTypeRepo.findAll());
            model.addAttribute("postlist", this.jobPostRepo.findAll());
            return "jobpackage/add";
        }

        this.jobPackageRepo.save(jobPackage);

        //Save Job Transtaction Summary Package

        JobTransactionSummary jts=new JobTransactionSummary();
        jts.setClient(clientRepo.findByEmail(jobPackage.getClient().getEmail()).get());
        jts.setTotalAmount(jobPackage.getTotalAmount());
        jts.setPaidAmount(jobPackage.getPaidAmount());
        double due = jobPackage.getTotalAmount() - jobPackage.getPaidAmount();
        jts.setDueAmount(due);
        jts.setTransDate(new Date());
        this.jobTransactionSummaryRepo.save(jts);

        model.addAttribute("jobpackage", new JobPackage());
        model.addAttribute("success", "Congratulations! Data save sucessfully");

        model.addAttribute("clientlist", this.clientRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("visatypelist", this.visaTypeRepo.findAll());
        model.addAttribute("companylist", this.companyRepo.findAll());
        model.addAttribute("companybranchlist", this.companyBranchRepo.findAll());
        model.addAttribute("typelist", this.jobTypeRepo.findAll());
        model.addAttribute("postlist", this.jobPostRepo.findAll());

        return "jobpackage/add";
    }
    @GetMapping(value = "list")
    public String jobIndex(Model model) {
        model.addAttribute("joblist", this.jobPackageRepo.findAll());
        return "jobpackage/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editShow(Model model,  @PathVariable("id") Long id) {
        model.addAttribute("joblist", this.jobPackageRepo.findAll());
        model.addAttribute("clientlist", this.clientRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("visatypelist", this.visaTypeRepo.findAll());
        model.addAttribute("companylist", this.companyRepo.findAll());
        model.addAttribute("companybranchlist", this.companyBranchRepo.findAll());
        model.addAttribute("typelist", this.jobTypeRepo.findAll());
        model.addAttribute("postlist", this.jobPostRepo.findAll());


        return "jobpackage/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String jobEdit(@Valid JobPackage jobPackage, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("joblist", this.jobPackageRepo.findAll());
            model.addAttribute("clientlist", this.clientRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());
            model.addAttribute("visatypelist", this.visaTypeRepo.findAll());
            model.addAttribute("companylist", this.companyRepo.findAll());
            model.addAttribute("companybranchlist", this.companyBranchRepo.findAll());
            model.addAttribute("typelist", this.jobTypeRepo.findAll());
            model.addAttribute("postlist", this.jobPostRepo.findAll());

            return "jobpackage/edit";
        }
        jobPackage.setId(id);
        this.jobPackageRepo.save(jobPackage);
        model.addAttribute("jobpackage", new JobPackage());
        model.addAttribute("success", "Congratulations! Data save sucessfully");

        model.addAttribute("clientlist", this.clientRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("visatypelist", this.visaTypeRepo.findAll());
        model.addAttribute("companylist", this.companyRepo.findAll());
        model.addAttribute("companybranchlist", this.companyBranchRepo.findAll());
        model.addAttribute("typelist", this.jobTypeRepo.findAll());
        model.addAttribute("postlist", this.jobPostRepo.findAll());

        return "jobpackage/edit";
    }
    @GetMapping(value = "/del/{id}")
    public String jobdel(@PathVariable("id") Long id) {
        if (id != null) {
            this.jobPackageRepo.deleteById(id);

        }
        return "redirect:/jobpackage/list";

    }

}
