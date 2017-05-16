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
        Cheese c = new Cheese();
        c.setDesc(desc);
        c.setName(name);
        cheeses.add(c);
        return "redirect:";
    }
}
