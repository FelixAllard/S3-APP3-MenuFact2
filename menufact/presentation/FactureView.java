package menufact.presentation;

import menufact.facture.Facture;
import menufact.plats.PlatChoisi;

public class FactureView {
    public String genererFactureTexte(Facture facture) {
        String factureGenere = "";
        int i = 1;

        factureGenere = "Facture generee.\n" +
                "Date:" + facture.getDate() + "\n" +
                "Description: " + facture.getDescription() + "\n" +
                "Client:" + (facture.getClient() != null ? facture.getClient().getNom() : "Aucun") + "\n" +
                "Les plats commandes:\n";

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : facture.getPlatchoisi()) {
            factureGenere += i + "     " + plat.getPlat().getDescription() + "  " + plat.getPlat().getPrix() + "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + facture.getTpsValeur() + "\n";
        factureGenere += "          TVQ:               " + facture.getTvqValeur() + "\n";
        factureGenere += "          Le total est de:   " + facture.total() + "\n";

        return factureGenere;
    }
}