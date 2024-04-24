package com.soulcode.helpdesk.controllers;

import com.soulcode.helpdesk.models.ChamadoModel;
import com.soulcode.helpdesk.models.UsuarioModel;
import com.soulcode.helpdesk.repositories.ChamadoRepository;
import com.soulcode.helpdesk.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ChamadoRepository chamadoRepository;

    @GetMapping("/index")
    public String login(UsuarioModel usuario, HttpSession session) {
        List<UsuarioModel> users = usuarioRepository.findByLogin(usuario.getLogin());
        UsuarioModel usuarioLogado = new UsuarioModel();

        String tela = null;
        for (UsuarioModel value : users) {
            if (value.getTipoUsuario().equals("tecnico")) {
                tela = "redirect:/tecnico/painel-tecnico?nome=" + value.getNome() + "?id=" + value.getId();
                usuarioLogado.setNome(value.getNome());
                usuarioLogado.setId(value.getId());
                session.setAttribute("usuarioLogado", usuarioLogado);
            } else {
                tela = "redirect:/usuario/painel-usuario?nome=" + value.getNome() + "?id=" + value.getId();
                usuarioLogado.setNome(value.getNome());
                usuarioLogado.setId(value.getId());
                session.setAttribute("usuarioLogado", usuarioLogado);
            }
        }
        return tela;
    }

    @GetMapping("usuario/cadastro-usuario")
    public String cadastroUsuario() {
        return "usuario/cadastro-usuario";
    }

    @PostMapping("/salvar")
    public String cadastroUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/index";
    }

    @GetMapping("/usuario/painel-usuario")
    public String painelUsuario(Model model, HttpSession session) {
        UsuarioModel usuarioLogado = (UsuarioModel) session.getAttribute("usuarioLogado");
        model.addAttribute("nome", usuarioLogado.getNome());
        return "usuario/painel-usuario";
    }

    @GetMapping("/usuario/listar-chamados")
    public String listarChamados(Model model, HttpSession session) {
        UsuarioModel usuarioLogado = (UsuarioModel) session.getAttribute("usuarioLogado");
        List<ChamadoModel> dados = chamadoRepository.findByIdUsuario(usuarioLogado.getId());

        model.addAttribute("nome", usuarioLogado.getNome());
        model.addAttribute("dados", dados);
        return "/usuario/listar-chamados";
    }
}
