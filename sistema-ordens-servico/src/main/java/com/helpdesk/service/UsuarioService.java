package com.helpdesk.service;

import com.helpdesk.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public boolean cadastrar(Usuario usuario) {

        if (buscarPorEmail(usuario.getEmail()) != null) {
            return false;
        }

        usuarios.add(usuario);

        return true;
    }

    public Usuario buscarPorEmail(String email) {

        return usuarios.stream()
                .filter(usuario ->
                        usuario.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public Usuario login(String email, String senha) {

        return usuarios.stream()
                .filter(usuario ->
                        usuario.getEmail().equalsIgnoreCase(email)
                        && usuario.getSenha().equals(senha))
                .findFirst()
                .orElse(null);
    }

    public proximoId() {
        
        if(Usuario.isEmpty()) {
            
        }
        return usuarios.stream()
        .filter(usuario -> usuario.getId())
        .findLast
    }
}