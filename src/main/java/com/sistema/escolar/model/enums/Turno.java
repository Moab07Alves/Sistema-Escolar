package com.sistema.escolar.model.enums;

public enum Turno {

    MANHA("M", "Manha"),
    TARDE("T", "Tarde"),
    NOITE("N", "Noite");

    private String codigo;
    private String descricao;

    Turno (String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
