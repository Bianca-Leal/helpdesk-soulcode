package com.soulcode.helpdesk.controllers;

import com.soulcode.helpdesk.models.ChamadoModel;
import com.soulcode.helpdesk.models.UsuarioModel;
import com.soulcode.helpdesk.repositories.ChamadoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ChamadoController {
    @Autowired
    ChamadoRepository chamadoRepository;

    @GetMapping("/usuario/novo-chamado")
    public ModelAndView minhaPagina(HttpSession session) {
        // Obter o usuário logado da sessão
        UsuarioModel usuarioLogado = (UsuarioModel) session.getAttribute("usuarioLogado");

        // Verificar se o usuário está logado
        if (usuarioLogado != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("id", usuarioLogado.getId());
            modelAndView.addObject("nome", usuarioLogado.getNome());
            modelAndView.setViewName("/usuario/novo-chamado");
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/index");
        }
    }

@PostMapping("/salvarChamado")
    public String salvarChamado(HttpSession session, ChamadoModel chamado) {
        UsuarioModel usuarioLogado = (UsuarioModel) session.getAttribute("usuarioLogado");
        chamado.setIdUsuario(usuarioLogado.getId());
        chamadoRepository.save(chamado);
        return "redirect:/usuario/listar-chamados";
    }
}
