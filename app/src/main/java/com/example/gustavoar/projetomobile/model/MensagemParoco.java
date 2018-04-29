package com.example.gustavoar.projetomobile.model;

import java.io.Serializable;


public class MensagemParoco implements Serializable{

    public long id;
    private String titulo;
    private String subtitulo;
    private String mensagem;

    public MensagemParoco() {
    }

    public MensagemParoco(String titulo, String subtitulo, String mensagem) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.mensagem = mensagem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
