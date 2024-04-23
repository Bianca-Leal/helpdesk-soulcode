package com.soulcode.helpdesk.controllers;

import com.soulcode.helpdesk.models.ChamadoModel;
import com.soulcode.helpdesk.models.UsuarioModel;
import com.soulcode.helpdesk.repositories.ChamadoRepository;
import com.soulcode.helpdesk.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    ChamadoRepository chamadoRepository;

    @GetMapping("/index")
    public String login(UsuarioModel usuario) {
        List<UsuarioModel> users = usuarioRepository.findByLogin(usuario.getLogin());

        String tela = null;
        for (UsuarioModel value : users) {
            if(value.getTipoUsuario().equals("tecnico")){
                tela =  "redirect:/tecnico/painel-tecnico?nome="+value.getNome();
            } else{
                tela =  "redirect:/usuario/painel-usuario?nome="+value.getNome();
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
        return "redirect:/usuario/cadastro-usuario";
    }

    @GetMapping("/usuario/painel-usuario")
    public String painelUsuario(@RequestParam String nome , Model model) {

        model.addAttribute("nome", nome);
        return "usuario/painel-usuario";
    }

    @GetMapping("/usuario/listar-chamados")
    public String listarChamados(Model model) {
        return "/usuario/listar-chamados";
    }



//    @GetMapping("/usuario/listar-chamados")
//    public String chamadosDisponiveis(Model model) {
//        List<ChamadoModel> items = chamadoRepository.findByStatus("Aguardando Técnico");
//        model.addAttribute("items", items);
//        return "/usuario/listar-chamados";
//    }
}
