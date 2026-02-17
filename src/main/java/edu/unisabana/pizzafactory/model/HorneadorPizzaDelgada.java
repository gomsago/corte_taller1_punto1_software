
package edu.unisabana.pizzafactory.model;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.unisabana.pizzafactory.model.factory.Horneador;

/**
 *
 * @author cesarvefe
 */
public class HorneadorPizzaDelgada implements Horneador {

    public void hornear() {
        Logger.getLogger(AmasadorPizzaDelgada.class.getName())
                .log(Level.INFO, "[~~] Horneando la pizza delgada con masa convencional.");

        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

}
