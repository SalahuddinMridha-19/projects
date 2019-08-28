package com.coderbd.simplethymeleaftemplate.controller;

import com.coderbd.simplethymeleaftemplate.entity.User;
import com.coderbd.simplethymeleaftemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = "list")
    public String view(Model model){
        List<User> userlist=this.userRepository.findAll();
        model.addAttribute("userlist",userlist);
        return "users/list";
    }
    @GetMapping(value = "add")
    public String addView(Model model){

        model.addAttribute("user",new User());
        return "users/add";
    }
    @PostMapping(value = "add")
    public String add(Model model, @Valid User user){
        if (user==null){
            model.addAttribute("errMsg","Something Wrong");
        }else {
            this.userRepository.save(user);
            model.addAttribute("sucMsg","Save Successfully");
        }
        return "users/add";
    }
}
