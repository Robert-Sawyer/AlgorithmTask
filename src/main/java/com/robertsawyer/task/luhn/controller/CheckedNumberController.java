package com.robertsawyer.task.luhn.controller;

import com.robertsawyer.task.luhn.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckedNumberController {

    @Autowired
    private NumberService numberService;

    public CheckedNumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/checked")
    public String showCheckedNumber(Model model) {
        model.addAttribute("showNumber", numberService.getLastNumber());
        return "/checked";
    }
}
