package com.epics82.agrovita.controller;

import com.epics82.agrovita.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.epics82.agrovita.entity.Machine;
import com.epics82.agrovita.repository.MachineRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private MachineRepository machineRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Welcome to Agrovita");
        return "index";
    }

    @GetMapping("/contact")
    public String contactUs() {
        return "contactUs";
    }


    @GetMapping("/crop-prediction")
    public String cropPrediction() {
        return "cropPrediction";
    }

    @GetMapping("/securehome")
    public String securehome() {
        return "SecureHome";
    }

    @GetMapping("/rent-machine")
    public String rent_machine() {
        return "rent_machine";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/machinery")
    public String machinery() {
        return "sell_machine";
    }


    @GetMapping("/product")
    public String product() {
        return "Product";
    }

    @GetMapping("/machines")
    public String listMachines(Model model) {
        List<Machine> machines = machineRepository.findAll();
        model.addAttribute("machines", machines);
        return "Product";
    }

    @GetMapping("/machines/add")
    public String showAddMachineForm(Model model) {
        model.addAttribute("machine", new Machine());
        return "addMachine";
    }

    @PostMapping("/machines/add")
    public String addMachine(@ModelAttribute Machine machine) {
        machineRepository.save(machine);
        return "redirect:/machines";
    }

    @GetMapping("/machines/edit/{id}")
    public String showEditMachineForm(@PathVariable Long id, Model model) {
        Machine machine = machineRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid machine Id:" + id));
        model.addAttribute("machine", machine);
        return "editMachine";
    }

    @PostMapping("/machines/edit/{id}")
    public String editMachine(@PathVariable Long id, @ModelAttribute Machine machine) {
        machine.setId(id);
        machineRepository.save(machine);
        return "redirect:/machines";
    }

    @GetMapping("/machines/delete/{id}")
    public String deleteMachine(@PathVariable Long id) {
        machineRepository.deleteById(id);
        return "redirect:/machines";
    }
}
