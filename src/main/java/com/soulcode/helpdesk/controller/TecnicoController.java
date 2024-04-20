package com.soulcode.helpdesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TecnicoController {

    @GetMapping("/tecnico")
    public String painelTecnico(Model model) {
        // Aqui você pode adicionar lógica para recuperar os chamados atribuídos ao técnico do serviço
        // Exemplo: List<Chamado> chamados = tecnicoService.listarChamadosAtribuidos(tecnico.getId());
        // model.addAttribute("chamados", chamados);
        return "tecnico/painel-tecnico";
    }


    @GetMapping("/tecnico/chamados-atribuidos")
    public String chamadosAtribuidos(Model model) {
        // Aqui você pode adicionar lógica para recuperar os chamados atribuídos ao técnico do serviço
        // Exemplo: List<Chamado> chamados = tecnicoService.listarChamadosAtribuidos(tecnico.getId());
        // model.addAttribute("chamados", chamados);
        return "tecnico/chamados-atribuidos";
    }

    @GetMapping("/tecnico/chamados-disponiveis")
    public String chamadosDisponiveis(Model model) {
        // Aqui você pode adicionar lógica para recuperar os chamados atribuídos ao técnico do serviço
        // Exemplo: List<Chamado> chamados = tecnicoService.listarChamadosAtribuidos(tecnico.getId());
        // model.addAttribute("chamados", chamados);
        return "tecnico/chamados-disponiveis";
    }

    @PostMapping("/tecnico/modificar-status")
    public String modificarStatus(@RequestParam("id") Long id,
                                  @RequestParam("novoStatus") String novoStatus) {
        // Aqui você pode adicionar lógica para modificar o status do chamado
        // Exemplo: tecnicoService.modificarStatusChamado(id, novoStatus);
        return "redirect:/tecnico"; // Redireciona de volta para a página de listagem de chamados do técnico
    }
}