package com.soulcode.helpdesk.controllers;

import com.soulcode.helpdesk.models.ChamadoModel;
import com.soulcode.helpdesk.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TecnicoController {
    @Autowired
    ChamadoRepository chamadoRepository;
    @GetMapping("/tecnico/painel-tecnico")
    public String painelTecnico(Model model) {
        return "tecnico/painel-tecnico";
    }

    @GetMapping("/tecnico/chamados-atribuidos")
    public String chamadosAtribuidos(Model model) {
        return "tecnico/chamados-atribuidos";
    }

    @GetMapping("tecnico/chamados-disponiveis")
    public String chamadosDisponiveis(Model model) {
        List<ChamadoModel> items = chamadoRepository.findByStatus("aguardando");
        model.addAttribute("items", items);
        return "tecnico/chamados-disponiveis";
    }

    @PostMapping("/tecnico/modificar-status")
    public String modificarStatus(@RequestParam("id") Long id,
                                  @RequestParam("novoStatus") String novoStatus) {
        return "redirect:/tecnico";
    }
}