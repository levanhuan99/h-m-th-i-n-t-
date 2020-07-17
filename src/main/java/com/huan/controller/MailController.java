package com.huan.controller;


import com.huan.model.Mail;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("mail", new Mail());
        return "form";
    }

    @ModelAttribute("typeSignature")
    public List<String> typeSignature(){
        List<String> list=new ArrayList<>();
        list.add("comment1");
        list.add("comment2");
        list.add("comment3");
        return list;
    }

    @PostMapping("/save")
    public String save(RedirectAttributes redirectAttributes,@ModelAttribute("mail") Mail mail){

        redirectAttributes.addFlashAttribute("messeage","added successful");
        return "redirect:/";
    }
}
