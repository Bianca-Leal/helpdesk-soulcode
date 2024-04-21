package com.soulcode.helpdesk.controllers;

import com.soulcode.helpdesk.models.UsuarioModel;
import com.soulcode.helpdesk.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/index")
    public String login() {
        return "index";
    }

    @RequestMapping(value="usuario/cadastro-usuario", method= RequestMethod.GET)
    public String cadastroUsuario() {
        return "usuario/cadastro-usuario";
    }

    @PostMapping("/salvar")
    public String cadastroUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/usuario/cadastro-usuario";
    }

    @GetMapping("/usuario/painel-usuario")
    public String painelUsuario(Model model) {
        // Aqui você pode adicionar lógica para recuperar os chamados do usuário do serviço
        // Exemplo: List<ChamadoModel> chamados = usuarioService.listarChamados(usuario.getId());
        // models.addAttribute("chamados", chamados);
        return "usuario/painel-usuario";
    }

    @GetMapping("/usuario/listar-chamados")
    public String listarChamados(Model model) {
        // Aqui você pode adicionar lógica para recuperar os chamados do usuário do serviço
        // Exemplo: List<ChamadoModel> chamados = usuarioService.listarChamados(usuario.getId());
        // models.addAttribute("chamados", chamados);
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
        model.addAttribute("mensagem", "ChamadoModel criado com sucesso!");
        return "usuario/painel-usuario"; // Modifique conforme o seu retorno esperado após o POST
    }
}
