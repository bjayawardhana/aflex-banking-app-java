package com.aflexbanking.controllers;

import com.aflexbanking.models.Account;
import com.aflexbanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class MainController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String getAllAccounts(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "account_list";
    }

    @GetMapping("/{id}")
    public String getAccountById(@PathVariable Long id, Model model) {
        model.addAttribute("account", accountService.getAccountById(id));
        return "account_detail";
    }

    @PostMapping
    public String createAccount(@ModelAttribute Account account) {
        accountService.createAccount(account);
        return "redirect:/accounts";
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "redirect:/accounts";
    }
}
