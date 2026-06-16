package menufact.presentation;

import menufact.Client;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public class FactureController {
    private Facture model;
    private FactureView view;

    public FactureController(Facture model, FactureView view) {
        this.model = model;
        this.view = view;
    }

    public void associerClient(Client client) {
        model.associerClient(client);
    }

    public void ajoutePlat(PlatChoisi p) throws FactureException {
        model.ajoutePlat(p);
    }

    public void fermer() throws FactureException {
        model.fermer();
    }

    public void ouvrir() throws FactureException {
        model.ouvrir();
    }

    public void payer() throws FactureException {
        model.payer();
    }

    public String afficherFacture() {
        return view.genererFactureTexte(model);
    }
}