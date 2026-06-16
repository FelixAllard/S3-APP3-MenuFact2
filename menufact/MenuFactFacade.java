package menufact;

import menufact.facture.Facture;

public class MenuFactFacade {
    private Chef chef = new Chef("Bob");

    public Facture preparerNouvelleFacture(Client client, Menu menu) {
        Facture f = new Facture("Commande Facade");
        f.associerClient(client);
        f.attacher(chef);
        return f;
    }
}