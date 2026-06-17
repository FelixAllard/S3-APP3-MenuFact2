package menufact.presentation;

import menufact.Client;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

/**
 * Classe Contrôleur pour le système (MVC)
 */
public class FactureController {
    /** Modèle pour la facture*/
    private Facture model;

    /** Vue pour la facture */
    private FactureView view;

    /**
     * Constructeur du contrôleur
     *
     * @param model le modèle du système
     * @param view la vue du système
     */
    public FactureController(Facture model, FactureView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Associer le client au modèle
     * @param client à relier au modèle
     */
    public void associerClient(Client client) {
        model.associerClient(client);
    }

    /**
     * Ajouter le plat choisi par le client du modèle
     * @param p plat choisi à ajouter
     * @throws FactureException si l'ajout d'un plat est impossible (ingrédients).
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException {
        model.ajoutePlat(p);
    }

    /**
     * Fermer la facture
     * @throws FactureException si l'état ne permet pas de la fermer (si elle est déjà fermée).
     */
    public void fermer() throws FactureException {
        model.fermer();
    }

    /**
     * Ouvrir la facture
     * @throws FactureException S'il est impossible d'ouvrir la facture (si elle est déjà fermée).
     */
    public void ouvrir() throws FactureException {
        model.ouvrir();
    }

    /**
     * Payer la facture
     * @throws FactureException S'il est impossible de payer (déjà payée).
     */
    public void payer() throws FactureException {
        model.payer();
    }

    /**
     * Afficher la facture (texte)
     * @return l'affichage de la facture en texte
     */
    public String afficherFacture() {
        return view.genererFactureTexte(model);
    }
}