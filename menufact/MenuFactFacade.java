package menufact;

import menufact.facture.Facture;
/**
 * Façade simplifiant la création et l'initialisation d'une facture.
 * Cette classe encapsule les étapes nécessaires pour préparer une nouvelle
 * facture
 */
public class MenuFactFacade {
    private Chef chef = new Chef("Bob");

    /**
     *Crée et initialise une nouvelle facture.
     * @param client le client associé à la facture
     * @param menu le menu utilisé pour la commande (actuellement non utilisé directement)
     * @return une facture initialisée avec client et chef
     */
    public Facture preparerNouvelleFacture(Client client, Menu menu) {
        Facture f = new Facture("Commande Facade");
        f.associerClient(client);
        f.attacher(chef);
        return f;
    }
}