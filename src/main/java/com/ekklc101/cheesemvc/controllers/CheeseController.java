package com.ekklc101.cheesemvc.controllers;

import com.ekklc101.cheesemvc.models.Cheese;
import com.ekklc101.cheesemvc.models.CheeseType;
import com.ekklc101.cheesemvc.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by raefo on 15-May-17.
 */

@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        String title = "My Cheeses";
        model.addAttribute("title", title);
        model.addAttribute("cheeses", cheeseDao.findAll());
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        String title = "Add Cheese";
        model.addAttribute("title", title);
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese c, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return displayAddCheeseForm(model);
        }
        cheeseDao.save(c);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        String title = "Remove Cheese";
        model.addAttribute("title", title);
        model.addAttribute("cheeses", cheeseDao.findAll());
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {
        for (int cheeseId : cheeseIds) {
            cheeseDao.delete(cheeseId);
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String displayEditCheeseForm(Model model, @PathVariable int id) {
        String title = "Edit Cheese";
        model.addAttribute("editcheese", cheeseDao.findOne(id));
        model.addAttribute("title", title);
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/edit";
    }

    @RequestMapping(value = "edit/**", method = RequestMethod.POST)
    public String processEditCheeseForm(@ModelAttribute @Valid Cheese c, Errors errors, Model model) {
        if (errors.hasErrors()) {
            String title = "Edit Cheese";
            model.addAttribute("editcheese", c);
            model.addAttribute("title", title);
            return "cheese/edit/" + Integer.toString(c.getId());
        } else {
            cheeseDao.delete(c.getId());
            cheeseDao.save(c);
            return "redirect:http://localhost:8080/cheese";
        }
    }
}
