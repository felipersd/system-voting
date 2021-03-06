package com.br.systemvoting.domain.enums;

public enum Status {

    OPEN("Aberta"), CLOSE("Fechada");

    private final String description;

    private Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
