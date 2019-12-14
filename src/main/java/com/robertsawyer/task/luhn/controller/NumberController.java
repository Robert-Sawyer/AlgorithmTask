package com.robertsawyer.task.luhn.controller;

import com.robertsawyer.task.luhn.dto.CheckNumberDTO;
import com.robertsawyer.task.luhn.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NumberController {

    @Autowired
    private NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/")
    public String prepareCheckingNumberForm(Model model) {
        model.addAttribute("checkNumber", new CheckNumberDTO());
        return "/checkNumber";
    }

    @PostMapping("/")
    public String checkNumberAndSave(@ModelAttribute("checkNumber") CheckNumberDTO numberDTO, BindingResult result) {

        if (result.hasErrors()) {
            return "/checkNumber";
        }

        boolean isCorrect = numberService.checkIsCorrect(numberDTO);
        numberDTO.setIsCorrect(isCorrect);
        numberService.saveNumber(numberDTO);

        return "/checkNumber";
    }



}
