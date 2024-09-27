package com.sistema.escolar.model.enums;

public enum Role {

    COORDENADOR("C", "Coordenador"),
    PROFESSOR("P", "Professor"),
    ALUNO("A", "Aluno");

    private String codigo;
    private String Descricao;

    Role(String codigo, String Descricao) {
        this.codigo = codigo;
        this.Descricao = Descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

}
