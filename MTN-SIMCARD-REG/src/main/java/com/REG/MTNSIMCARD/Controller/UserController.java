package com.REG.MTNSIMCARD.Controller;

import com.REG.MTNSIMCARD.Models.UserModel;
import com.REG.MTNSIMCARD.Repository.ClientRepository;
import com.REG.MTNSIMCARD.Service.ClientService;
import com.REG.MTNSIMCARD.imp.ClientServiceImplementation;
import com.REG.MTNSIMCARD.imp.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    UserServiceImplementation userService;

    @Autowired
    public UserController( UserServiceImplementation userService) {
        this.userService = userService;
    }

    @GetMapping("/user/signup")
    public String getSignupForm(Model model){
        UserModel user = new UserModel();
        model.addAttribute("user", user);
        return "signupPage";
    }

    @PostMapping("/user/save")
        public String saveUser(Model model, UserModel user, RedirectAttributes ra){
        try {
            UserModel savedUser = userService.saveUser(user);
            model.addAttribute("user", savedUser);
            ra.addFlashAttribute("message", "User saved successfully");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        user.setUsername("");
        user.setEmail("");
        user.setPassword("");
        return "signupPage";

    }

    @GetMapping("/user/login")
    public String getLoginForm(Model model){
        try {
             UserModel user = new UserModel();
             model.addAttribute("user", user);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "loginPage";
    }

@PostMapping("/user/login")
    public String userLogin( UserModel username, Model model, RedirectAttributes ra){
        try{
            UserModel user = userService.findUserByUsername(username);
            model.addAttribute("user",user);
            if (user!=null){

                    if (user.getPassword().equals(user.getPassword())){
                        return "description";
                    }else {
                        ra.addFlashAttribute("message", "Wrong password");
                        return "/user/login";
                    }

            }else {
                ra.addFlashAttribute("message", "Invalid credential");
                return "redirect:/user/login";
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
     return "description";
    }

    @GetMapping("/admin/login")
    public String adminLoginForm(Model model){
        try {
            UserModel user = new UserModel();
            model.addAttribute("user", user);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "adminLogin";
    }

    @GetMapping("/adminViewPage")
    public String adminView(Model model){
        return"adminViewPage";
    }



    @PostMapping("/admin/login")
    public String adminLogin( UserModel username, Model model, RedirectAttributes ra){
        try{
            UserModel user = userService.findUserByUsername(username);
            model.addAttribute("user",user);
            if (user!=null){
                if (user.getUsername().equals("admin")){
                    if (user.getPassword().equals(user.getPassword())){
                        return "redirect:/adminViewPage";
                    }else {
                        ra.addFlashAttribute("message", "Wrong password");
                        return "redirect:/adminViewPage";
                    }
                }else {
                    ra.addFlashAttribute("message","invalid username or password");
                }

            }else {
                ra.addFlashAttribute("message", "Invalid credential");
                return "redirect:/user/login";
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "adminViewPage";
    }

}
