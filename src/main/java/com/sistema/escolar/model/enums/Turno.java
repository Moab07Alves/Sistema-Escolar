package com.sistema.escolar.model.enums;

public enum Turno {

    MANHA("M", "Manha"),
    TARDE("T", "Tarde"),
    NOITE("N", "Noite");

    private String sigla;
    private String descricao;

    Turno (String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
