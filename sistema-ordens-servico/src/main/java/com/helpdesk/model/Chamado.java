package com.helpdesk.model;

public class Chamado {

    private int id;
    private String titulo;
    private String descricao;
    private StatusChamado status;
    private Usuario cliente;

    public Chamado(
        int id,
        String titulo,
        String descricao,
        StatusChamado status,
        Usuario cliente
    )

    {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.cliente = cliente;
        this.status = StatusChamado.ABERTO;
    }

    public int getId () {
        return id;
    }
    
    public String getTitulo() {
    return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public Usuario getCliente() {
        return cliente;
    }
    
}
