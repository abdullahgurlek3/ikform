/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Admin;
import entities.User;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import transactions.AdminUtil;
import transactions.InsertDatabase;
import util.AdminState;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@RequestMapping("/admin/")
@Controller
public class adminController {

    @Autowired
    InsertDatabase insertDatabase;

    @Autowired
    AdminUtil adminUtil;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap map) {
        if (adminUtil.checkAdminSession() == AdminState.LOGIN) {
            return "redirect:/admin/list";
        }
        map.addAttribute("Admin", new Admin());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@Valid @ModelAttribute("Admin") Admin admin, BindingResult result) {

        if ((result.getFieldError("username") == null)
                & (result.getFieldError("password") == null)) {

            AdminState adminState = adminUtil.loginAdmin(
                    admin.getUsername(), admin.getPassword());

            switch (adminState) {
                case LOGGING: {
                    return "redirect:/admin/list";
                }
                case LOGIN: {
                    return "redirect:/admin/list";
                }
                case NOTACTIVATED: {
                    FieldError fieldError = new FieldError("Admin", "username", "Kullanıcı aktif edilmedi");
                    result.addError(fieldError);
                    return "login";
                }
                case IDNOTDEFINED: {
                    FieldError fieldError = new FieldError("Admin", "username", "Kullanıcı tanımlı değil");
                    result.addError(fieldError);
                    return "login";
                }
                default: {
                    throw new RuntimeException("Admin Login durum hatası " + adminState);
                }

            }

        }

        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap map) {
        map.addAttribute("Admin", new Admin());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(@Valid @ModelAttribute("Admin") Admin admin, BindingResult result, ModelMap map) {
        if (result.hasErrors()) {
            return "register";
        }

        String key = UUID.randomUUID().toString();
        admin.setActivationKey(key);

        insertDatabase.addAdmin(admin);

        map.addAttribute("activateLink", "/admin/activate?id=" + admin.getId() + "&key=" + key);

        return "registerSendMail";
    }

    @RequestMapping(value = "/activate", method = RequestMethod.GET)
    public String activate(@RequestParam("key") String key, @RequestParam("id") long id, ModelMap map) {
        String message = null;

        switch (adminUtil.checkAdminActivation(id, key)) {
            case IDORKEYNOTDEFINED: {
                message = "Kullanıcı veya key tanımlı değil";
                break;
            }
            case ACTIVATED: {
                message = "Kullanıcı zaten aktif.";
                break;
            }
            case BEINGACTIVE: {
                message = "Kullanıcı aktif Edildi.";
                break;
            }
        }
        map.addAttribute("message", message);
        return "activate";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        if (adminUtil.checkAdminSession() == AdminState.NOTLOGIN) {
            return "redirect:/admin/login";
        }

        List<User> users = insertDatabase.getAll();

        map.addAttribute("users", users);

        return "list";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout() {
        AdminState state = adminUtil.logoutAdmin();
        return "asgasg";
    }

}
