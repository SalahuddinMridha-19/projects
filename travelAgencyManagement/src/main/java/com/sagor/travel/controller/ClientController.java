package com.sagor.travel.controller;



import com.sagor.travel.entity.Client;
import com.sagor.travel.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;


@Controller
@RequestMapping(value = "/client/")
public class ClientController {
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private VisaTypeRepo visaTypeRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private AgencyRepo agencyRepo;

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private ImageOptimizer imageOptimizer;

    @GetMapping(value = "add")
    public String addShow(Model model) {
        model.addAttribute("client",new Client());
//        model.addAttribute("clientlist", this.clientRepo.findAll());
        model.addAttribute("visaTypelist", this.visaTypeRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("agencylist", this.agencyRepo.findAll());
        model.addAttribute("branchlist", this.branchRepo.findAll());

        return "client/add";

    }
    @PostMapping(value = "add")

    public String clientSave(@Valid Client client, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file) {
       client.setRegiDate(new Date());
        if (bindingResult.hasErrors()) {
            model.addAttribute("clients", new Client());
            model.addAttribute("clientlist", this.clientRepo.findAll());
            model.addAttribute("visaTypelist", this.visaTypeRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());
            model.addAttribute("agencylist", this.agencyRepo.findAll());
            model.addAttribute("branchlist", this.branchRepo.findAll());

            return "client/add";
        }
        try {
            //////////////////////For Image Upload start /////////////////////
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

            Files.write(path, bytes);
            client.setFileName("new-" + file.getOriginalFilename());
            client.setFileSize(file.getSize());
            // user.setFile(file.getBytes());
            client.setFilePath("/images/" + "new-" + file.getOriginalFilename());
            client.setFileExtension(file.getContentType());
            //////////////////////For Image Upload end/////////////////////


            this.clientRepo.save(client);
            model.addAttribute("clients", new Client());
            model.addAttribute("success", "Congratulations! Data save sucessfully");
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.3f, 100, 100);

        }catch (Exception e){
            e.printStackTrace();

        }

        model.addAttribute("clientlist", this.clientRepo.findAll());
        model.addAttribute("visaTypelist", this.visaTypeRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("agencylist", this.agencyRepo.findAll());
        model.addAttribute("branchlist", this.branchRepo.findAll());


        return "client/add";
    }
    @GetMapping(value = "list")
    public String clientIndex(Model model) {
        model.addAttribute("clientlist", this.clientRepo.findAll());
        return "client/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editShow(Model model,  @PathVariable("id") Long id) {
        model.addAttribute("visaTypelist", this.visaTypeRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("agencylist", this.agencyRepo.findAll());
        model.addAttribute("branchlist", this.branchRepo.findAll());
        model.addAttribute("clients", this.clientRepo.getOne(id));

        return "client/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String clientEdit(@Valid Client client, BindingResult bindingResult, @PathVariable("id") Long id, Model model, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("clientlist", this.clientRepo.findAll());
            model.addAttribute("visaTypelist", this.visaTypeRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());
            model.addAttribute("agencylist", this.agencyRepo.findAll());
            model.addAttribute("branchlist", this.branchRepo.findAll());

            return "client/edit";
        }
        try {
            //////////////////////For Image Upload start /////////////////////
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

            Files.write(path, bytes);
            client.setFileName("new-" + file.getOriginalFilename());
            client.setFileSize(file.getSize());
            // user.setFile(file.getBytes());
            client.setFilePath("/images/" + "new-" + file.getOriginalFilename());
            client.setFileExtension(file.getContentType());
            //////////////////////For Image Upload end/////////////////////


            client.setId(id);
            this.clientRepo.save(client);
            model.addAttribute("clients", new Client());
            model.addAttribute("success", "Congratulations! Data save sucessfully");
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.3f, 100, 100);

        }catch (Exception e){
            e.printStackTrace();

        }


        model.addAttribute("clientlist", this.clientRepo.findAll());
        model.addAttribute("visaTypelist", this.visaTypeRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());
        model.addAttribute("agencylist", this.agencyRepo.findAll());
        model.addAttribute("branchlist", this.branchRepo.findAll());

        return "client/edit";
    }
    @GetMapping(value = "/del/{id}")
    public String clientdel(@PathVariable("id") Long id) {
        if (id != null) {
            this.agencyRepo.deleteById(id);

        }
        return "redirect:/client/list";

    }

}
