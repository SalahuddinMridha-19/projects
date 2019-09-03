package com.sagor.pharmacymanagement.controller;


import com.sagor.pharmacymanagement.entity.Category;
import com.sagor.pharmacymanagement.repo.CategoryRepo;
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
@RequestMapping(value = "/cat/")
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;


    @GetMapping(value = "add")
    public String addShow(Category category) {
        return "category/add";

    }


    @PostMapping(value = "add")
    public String categorySave(@Valid Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "category/add";
        } else {
            if (category != null) {
                Category category1 = this.categoryRepo.findByCategoryName(category.getCategoryName());
                if (category1 != null) {
                    model.addAttribute("exist", "Category allready exist");

                } else {
//                    category.setCategoryName(category.getCategoryName().toUpperCase());
                    this.categoryRepo.save(category);
                    model.addAttribute("category", new Category());
                    model.addAttribute("success", "Category Add Successfully");
                }

            }
        }


        return "category/add";
    }


    @GetMapping(value = "list")
    public String categoryIndex(Model model) {
        model.addAttribute("catlist", categoryRepo.findAll());
        return "category/list";
    }



    @GetMapping(value = "edit/{id}")
    public String editShow(Model model, @PathVariable("id") Long id){
        model.addAttribute("category", this.categoryRepo.getOne(id));
        return "category/edit";

    }


    @PostMapping(value = "edit/{id}")
    public String categoryEdit(@Valid Category category, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "category/edit";
        } else {
            if (category != null) {
                Category category1 = this.categoryRepo.findByCategoryName(category.getCategoryName());
                if (category1 != null) {
                    model.addAttribute("exist", "Category allready exist");

                } else {
//                    category.setCategoryName(category.getCategoryName().toUpperCase());
                    category.setCategoryId(id);
                    this.categoryRepo.save(category);
                    model.addAttribute("category", new Category());
                    model.addAttribute("success", "Category Add Successfully");
                }

            }
        }


        return "category/edit";
    }



    @GetMapping(value = "del/{id}")
    public String barnddel(@PathVariable("id") Long id) {
        if(id != null){
            this.categoryRepo.deleteById(id);

        }
        return "redirect:/cat/list";

    }

}
