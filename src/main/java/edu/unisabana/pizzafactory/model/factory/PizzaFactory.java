package edu.unisabana.pizzafactory.model.factory;

public interface PizzaFactory {

    Amasador crearAmasador();

    Moldeador crearMoldeador();

    Horneador crearHorneador();
}
