package com.soulcode.helpdesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @GetMapping("/usuario")
    public String painelUsuario(Model model) {
        // Aqui você pode adicionar lógica para recuperar os chamados do usuário do serviço
        // Exemplo: List<Chamado> chamados = usuarioService.listarChamados(usuario.getId());
        // model.addAttribute("chamados", chamados);
        return "usuario/painel-usuario";
    }

    @GetMapping("/usuario/listar-chamados")
    public String listarChamados(Model model) {
        // Aqui você pode adicionar lógica para recuperar os chamados do usuário do serviço
        // Exemplo: List<Chamado> chamados = usuarioService.listarChamados(usuario.getId());
        // model.addAttribute("chamados", chamados);
        return "/usuario/listar-chamados";
    }


    @GetMapping("/usuario/novo-chamado")
    public String novoChamadoForm() {
        // Renderiza a página para criar um novo chamado
        return "usuario/novo-chamado";
    }

    @PostMapping("/usuario/novo-chamado")
    public String criarChamado(@RequestParam("descricao") String descricao,
                               @RequestParam("prioridade") String prioridade, Model model) {
        // Aqui você pode adicionar lógica para criar um novo chamado
        // Exemplo: usuarioService.criarChamado(usuario.getId(), descricao, prioridade);
        // Adicione um modelo para confirmar a criação ou redirecione para outra página.
        model.addAttribute("mensagem", "Chamado criado com sucesso!");
        return "usuario/painel-usuario"; // Modifique conforme o seu retorno esperado após o POST
    }
}
