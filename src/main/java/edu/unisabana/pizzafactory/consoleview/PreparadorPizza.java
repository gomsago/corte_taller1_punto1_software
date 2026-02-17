
package edu.unisabana.pizzafactory.consoleview;

import edu.unisabana.pizzafactory.model.AmasadorPizzaDelgada;
import edu.unisabana.pizzafactory.model.ExcepcionParametrosInvalidos;
import edu.unisabana.pizzafactory.model.HorneadorPizzaDelgada;
import edu.unisabana.pizzafactory.model.Ingrediente;
import edu.unisabana.pizzafactory.model.MoldeadorPizzaDelgada;
import edu.unisabana.pizzafactory.model.Tamano;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.unisabana.pizzafactory.model.factory.PizzaFactory;
import edu.unisabana.pizzafactory.model.factory.Amasador;
import edu.unisabana.pizzafactory.model.factory.Moldeador;
import edu.unisabana.pizzafactory.model.factory.Horneador;
import edu.unisabana.pizzafactory.model.factory.PizzaDelgadaFactory;

/**
 *
 * @author cesarvefe
 */
public class PreparadorPizza {
    private PizzaFactory factory;

    public PreparadorPizza(PizzaFactory factory) {
        this.factory = factory;
    }

    public static void main(String args[]) {
        try {
            Ingrediente[] ingredientes = new Ingrediente[] { new Ingrediente("queso", 1), new Ingrediente("jamon", 2) };
            PizzaFactory factory = new PizzaDelgadaFactory();
            PreparadorPizza pp = new PreparadorPizza(factory);

            pp.prepararPizza(ingredientes, Tamano.MEDIANO);
        } catch (ExcepcionParametrosInvalidos ex) {
            Logger.getLogger(PreparadorPizza.class.getName()).log(Level.SEVERE,
                    "Problema en la preparacion de la Pizza", ex);
        }

    }

    public void prepararPizza(Ingrediente[] ingredientes, Tamano tam)
            throws ExcepcionParametrosInvalidos {
        Amasador am = factory.crearAmasador();
        Moldeador mp = factory.crearMoldeador();
        Horneador hpd = factory.crearHorneador();

        am.amasar();
        if (tam == Tamano.PEQUENO) {
            mp.moldearPizzaPequena();
        } else if (tam == Tamano.MEDIANO) {
            mp.moldearPizzaMediana();
        } else {
            throw new ExcepcionParametrosInvalidos("Tamano de piza invalido:" + tam);
        }
        aplicarIngredientes(ingredientes);
        hpd.hornear();
    }

    private void aplicarIngredientes(Ingrediente[] ingredientes) {
        Logger.getLogger(PreparadorPizza.class.getName())
                .log(Level.INFO, "APLICANDO INGREDIENTES!:{0}", Arrays.toString(ingredientes));

        // CODIGO DE LLAMADO AL MICROCONTROLADOR

    }

}
