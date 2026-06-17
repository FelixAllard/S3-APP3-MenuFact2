package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;


public interface FactureEtat {

    void ajoutePlat(Facture facture, PlatChoisi p) throws FactureException;


    void ouvrir(Facture facture) throws FactureException;


    void fermer(Facture facture) throws FactureException;


    void payer(Facture facture) throws FactureException;
}