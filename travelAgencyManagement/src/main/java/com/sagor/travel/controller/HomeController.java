package com.sagor.travel.controller;



import com.sagor.travel.entity.JobTransactionSummary;
import com.sagor.travel.entity.StudentSummary;
import com.sagor.travel.repo.ClientRepo;
import com.sagor.travel.repo.JobTransactionSummaryRepo;
import com.sagor.travel.repo.StudentSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

     @Autowired
     private StudentSummaryRepo studentSummaryRepo;
     @Autowired
     private ClientRepo clientRepo;
     @Autowired
     private JobTransactionSummaryRepo jobTransactionSummaryRepo;

    @GetMapping(value = "/")
    public String dashboardView(Model model) {
        return "dashboard";

    }



    @GetMapping(value = "/order")
    public String orderView() {
        return "contact/order";

    }


    @GetMapping(value = "/location")
    public String locationView() {
        return "contact/location";

    }

    @GetMapping(value = "/studentSummary")
    public String summaryView(Model model) {
        model.addAttribute("studentsummarylist", this.studentSummaryRepo.findAll());
        return "summary/studentSummary";

    }
    @GetMapping(value = "/summary/{id}")
    public String studentsummaryViewById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("clientSummaryById", this.clientRepo.getOne(id));
        return "summary/studentsummarybyid";
    }

    @GetMapping(value = "/summaryupdate/{id}")
    public String viewstudentsummaryUpdateViewById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("studentsummaryById", this.studentSummaryRepo.getOne(id));
        return "summary/studentSummaryUpdate";
    }

    @PostMapping(value = "/summaryupdate/{id}")
    public String studentsummaryUpdateViewById(Model model, @PathVariable("id") Long id, @RequestParam("todayamount") String todayamount) {

        StudentSummary studentSummary = this.studentSummaryRepo.getOne(id);
        double dueAm=studentSummary.getDueAmount() - Double.parseDouble(todayamount);
        studentSummary.setDueAmount(dueAm);
        double payAm = studentSummary.getPaymentAmount() + Double.parseDouble(todayamount);
        studentSummary.setPaymentAmount(payAm);
                this.studentSummaryRepo.save(studentSummary);
        model.addAttribute("studentsummaryById", this.studentSummaryRepo.getOne(id));
        return "summary/studentSummaryUpdate";
    }

//  Save Job Transaction summary
    @GetMapping(value = "/jobtransactionSummary")
    public String jobTransactionView(Model model) {
    model.addAttribute("jobsummarylist", this.jobTransactionSummaryRepo.findAll());
    return "summary/jobtransactionsummary";
}

    @GetMapping(value = "/jobtransactionupdate/{id}")
    public String viewjobsummaryUpdateViewById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("jobsummaryById", this.jobTransactionSummaryRepo.getOne(id));
        return "summary/jobtransactionupdate";
    }

    @PostMapping(value = "/jobtransactionupdate/{id}")
    public String jobsummaryUpdateViewById(Model model, @PathVariable("id") Long id, @RequestParam("todayamount") double todayamount) {
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        JobTransactionSummary jts = this.jobTransactionSummaryRepo.getOne(id);
//        jts.setClient(clientRepo.findByEmail(jts.getClient().getEmail()).get());
//        jts.setTotalAmount(jts.getTotalAmount());
        double dueAm=jts.getDueAmount() - todayamount;
        jts.setDueAmount(dueAm);
        double payAm = jts.getPaidAmount() +todayamount;
        jts.setPaidAmount(payAm);
        this.jobTransactionSummaryRepo.save(jts);
        model.addAttribute("jobsummaryById", this.jobTransactionSummaryRepo.getOne(id));
        return "summary/jobtransactionupdate";
    }
}
