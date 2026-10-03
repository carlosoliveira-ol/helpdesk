package com.helpdesk.ui;

import com.helpdesk.service.UsuarioService;

import java.util.Scanner;

import com.helpdesk.model.TipoUsuario;
import com.helpdesk.model.Usuario;

public class MenuInicial {
    
    private UsuarioService usuarioService;
    private Scanner scanner;

    public MenuInicial(UsuarioService usuarioService, Scanner scanner) {
        this.usuarioService = usuarioService;
        this.scanner = scanner;
    }

    public void exibir() {

        int opcao;

        do {

            System.out.println("========================");
            System.out.println("       HELPDESK       ");
            System.out.println("========================");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastro");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    login();
                    break;
                case 2:
                    cadastrar();
                    break;
                case 0:
                    System.out.println("Encerrando Sistema.");
                    break;
                default:
                    System.out.println("Opção inválida!"); 
            }

        } while(opcao != 0);
    }

    private void cadastrar() {

        System.out.println("=========================");
        System.out.println("         CADASTRO        ");
        System.out.println("=========================");

        System.out.println("Nome : ");
        String nome = scanner.nextLine();

        System.out.println("Email : ");
        String email = scanner.nextLine();

        System.out.println("Senha : ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(
            gerarId(),
            nome,
            email,
            senha,
            TipoUsuario.CLIENTE
        );

        boolean cadastrado = usuarioService.cadastrar(usuario);

        if (cadastrado) {

            System.out.println("Usuário cadastrado com sucesso!!");

        } else {

            System.out.println("Este email já está cadastrado.");

        }
    }

    private void login() {

        System.out.println("=========================");
        System.out.println("          LOGIN          ");
        System.out.println("=========================");

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = usuarioService.login(email, senha);

        if (usuario == null) {

            System.out.println("\nE-mail ou senha incorretos.");
            return;
        }

        System.out.println("\nLogin realizado com sucesso!");
        System.out.println("Olá, " + usuario.getNome() + "!");

        if (usuario.getTipo() == TipoUsuario.CLIENTE) {

            System.out.println("Perfil: Cliente");

        } else if (usuario.getTipo() == TipoUsuario.TECNICO) {

            System.out.println("Perfil: Técnico");
        }
    }

    private int gerarId() {

        return usuarioService.proximoId();
    }
}
    
