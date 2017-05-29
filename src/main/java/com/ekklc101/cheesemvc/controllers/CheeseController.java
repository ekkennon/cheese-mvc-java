package com.ekklc101.cheesemvc.controllers;

import com.ekklc101.cheesemvc.models.Cheese;
import com.ekklc101.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            CheeseData.add(c);
            return "redirect:";
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
        return "redirect:";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String displayEditCheeseForm(Model model, @PathVariable int id) {
        String title = "Edit Cheese";
        model.addAttribute("editcheese", CheeseData.getById(id));
        model.addAttribute("title", title);
        return "cheese/edit";
    }

    @RequestMapping(value = "edit/**", method = RequestMethod.POST)
    public String processEditCheeseForm(@ModelAttribute Cheese c) {
        CheeseData.edit(c);
        return "redirect:http://localhost:8080/cheese";
    }
}
