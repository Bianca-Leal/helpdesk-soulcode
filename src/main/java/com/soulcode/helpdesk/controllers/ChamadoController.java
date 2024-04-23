package com.soulcode.helpdesk.controllers;

import com.soulcode.helpdesk.models.ChamadoModel;
import com.soulcode.helpdesk.models.UsuarioModel;
import com.soulcode.helpdesk.repositories.ChamadoRepository;
import com.soulcode.helpdesk.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ChamadoController {
    @Autowired
    ChamadoRepository chamadoRepository;
    UsuarioRepository usuarioRepository;

    @PostMapping("/salvarChamado")
    public String salvarChamado(ChamadoModel chamado) {


        chamadoRepository.save(chamado);
        return "redirect:/usuario/listar-chamados";
    }

    @GetMapping("/usuario/novo-chamado")
    public String novoChamadoForm() {
        return "usuario/novo-chamado";
    }
}
