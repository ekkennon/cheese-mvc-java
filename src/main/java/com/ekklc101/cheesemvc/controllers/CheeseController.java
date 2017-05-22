package com.ekklc101.cheesemvc.controllers;

import com.ekklc101.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    static List<Cheese> cheeses = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {
        String title = "My Cheeses";
        model.addAttribute("title", title);
        model.addAttribute("cheeses", cheeses);
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        String title = "Add Cheese";
        model.addAttribute("title", title);
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String name, @RequestParam String desc) {
        if (validInput(name)) {
            Cheese c = new Cheese();
            c.setDesc(desc);
            c.setName(name);
            cheeses.add(c);
            return "redirect:";
        } else {
            return "redirect:/cheese/invalid";
        }
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        String title = "Remove Cheese";
        model.addAttribute("title", title);
        model.addAttribute("cheeses", cheeses);
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam String cheeseName) {
        cheeses.removeIf(c -> c.getName().equals(cheeseName));
        return "redirect:";
    }

    @RequestMapping(value="invalid")
    public String onError(Model model) {
        String title = "Invalid Input";
        model.addAttribute("title", title);
        return "cheese/invalid";
    }

    private boolean validInput(String input) {
        for (int c : input.toCharArray()) {
            if (c > 122 || c < 32 || (c < 65 && c > 32) || (c < 97 && c > 90)) {//space=32,uppercase=65-90,lowercase=97-122
                return false;
            }
        }
        return true;
    }
}
