/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.User;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import transactions.InsertDatabase;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@RequestMapping("/")
@Controller
public class indexController {

    @Autowired
    InsertDatabase insertDatabase;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.addAttribute("User", new User());
        return "insertform";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String indexOk(@Valid @ModelAttribute("User") User user, BindingResult result, ModelMap map) {
        System.err.println(result);
        if (result.hasErrors()) {
            return "insertform";
        } else {
            insertDatabase.insert(user);
            insertDatabase.getAll();
        }
        return "ok";
    }

}
