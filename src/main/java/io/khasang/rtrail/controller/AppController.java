package io.khasang.rtrail.controller;

import io.khasang.rtrail.Model.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// http://localhost:8080
public class AppController {

    @Autowired
    private CreateTable createTable;

    @RequestMapping("/")
    public String getHelloPage(Model model){
        model.addAttribute("name", "World!");
        return "index";
    }

    @RequestMapping("/table")
    public String getCreateTablePage(Model model) {
        model.addAttribute("message", createTable.createTableStatus());
        return "table";
    }

}
