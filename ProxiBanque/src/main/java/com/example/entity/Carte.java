package com.example.entity;

import lombok.Getter;
import lombok.Setter;

public class Carte {
    public enum TypeCarte {
        ELECTRON,
        PREMIER
    }

    @Getter
    @Setter
    private TypeCarte typeCarte;

    private boolean active = true;

    public Carte(TypeCarte typeCarte) {
        this.typeCarte = typeCarte;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
