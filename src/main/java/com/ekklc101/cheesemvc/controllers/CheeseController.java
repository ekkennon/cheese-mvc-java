package com.ekklc101.cheesemvc.controllers;

import com.ekklc101.cheesemvc.models.Cheese;
import com.ekklc101.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by raefo on 15-May-17.
 */

@Controller
@RequestMapping("cheese")
public class CheeseController {


    @RequestMapping(value = "")
    public String index(Model model) {
        String title = "My Cheeses";
        model.addAttribute("title", title);
        model.addAttribute("cheeses", CheeseData.getAll());
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        String title = "Add Cheese";
        model.addAttribute("title", title);
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute Cheese c) {
        //if (CheeseData.isValidInput(name)) {
            //Cheese c = new Cheese(name, desc);
            CheeseData.add(c);
            return "redirect:";
        //} else {
            //return "redirect:/cheese/invalid";
        //}
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        String title = "Remove Cheese";
        model.addAttribute("title", title);
        model.addAttribute("cheeses", CheeseData.getAll());
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {
        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }
        //cheeses.removeIf(c -> c.getName().equals(cheeseName));
        return "redirect:";
    }

    @RequestMapping(value="invalid")
    public String onError(Model model) {
        String title = "Invalid Input";
        model.addAttribute("title", title);
        return "cheese/invalid";
    }
}
