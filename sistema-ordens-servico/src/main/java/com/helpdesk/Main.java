package com.helpdesk;

import com.helpdesk.service.UsuarioService;
import com.helpdesk.ui.MenuInicial;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UsuarioService usuarioService = new UsuarioService();

        MenuInicial menuInicial = new MenuInicial(usuarioService, scanner);

        menuInicial.exibir();

        scanner.close();
    }
}