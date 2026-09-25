package model;

import exception.PersonagemMortoExeption;

public interface Acao {
    void ataque() throws PersonagemMortoExeption;
    void cura();
    void defesa();
}
