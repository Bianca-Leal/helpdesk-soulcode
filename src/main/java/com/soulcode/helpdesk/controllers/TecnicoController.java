package com.soulcode.helpdesk.controllers;

import com.soulcode.helpdesk.models.ChamadoModel;
import com.soulcode.helpdesk.models.UsuarioModel;
import com.soulcode.helpdesk.repositories.ChamadoRepository;
import com.soulcode.helpdesk.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TecnicoController {
    @Autowired
    ChamadoRepository chamadoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @GetMapping("/tecnico/painel-tecnico")
    public String painelTecnico(Model model, HttpSession session) {
        UsuarioModel usuarioLogado = (UsuarioModel) session.getAttribute("usuarioLogado");
        model.addAttribute("nome", usuarioLogado.getNome());
        return "tecnico/painel-tecnico";
    }

    @GetMapping("/tecnico/chamados-atribuidos")
    public String chamadosAtribuidos(Model model, HttpSession session) {
        UsuarioModel usuarioLogado = (UsuarioModel) session.getAttribute("usuarioLogado");
        List<ChamadoModel> items = chamadoRepository.findByIdUsuario(usuarioLogado.getId());
        model.addAttribute("nome", usuarioLogado.getNome());
        model.addAttribute("items", items);
        return "tecnico/chamados-atribuidos";
    }

    @GetMapping("tecnico/chamados-disponiveis")
    public String chamadosDisponiveis(Model model, HttpSession session) {
        UsuarioModel usuarioLogado = (UsuarioModel) session.getAttribute("usuarioLogado");
        List<ChamadoModel> items = chamadoRepository.findAll();
        model.addAttribute("nome", usuarioLogado.getNome());
        model.addAttribute("items", items);
        return "tecnico/chamados-disponiveis";
    }

    @GetMapping("/tecnico/modificar-status")
    public String modificarStatus() {
        return "tecnico/modificar-status";
    }

    @GetMapping("/tecnico/modificar-status/{id}")
    public String modificarStatus(@PathVariable Long id, Model model, HttpSession session) {
        UsuarioModel usuarioLogado = (UsuarioModel) session.getAttribute("usuarioLogado");
        ChamadoModel chamado = chamadoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Chamado inválido"));
        model.addAttribute("chamado", chamado);
        return "tecnico/chamados-atribuidos";
    }
}