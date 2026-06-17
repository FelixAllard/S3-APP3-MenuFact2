package menufact;

import ingredients.*;
import inventaire.InventaireService;
import menufact.facture.exceptions.FactureException;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.plats.*;
import menufact.plats.Etat.Commande;
import menufact.plats.Etat.EnPreparation;
import menufact.plats.Etat.ImpossibleServir;
import menufact.presentation.FactureView;

public class TestMenuFact02 {


    public static void main(String[] args) {
        boolean trace = true;
        TestMenuFact02 t = new TestMenuFact02();
        PlatAuMenu p1 = null;
        PlatAuMenu p2 = null;
        PlatAuMenu p3 = null;
        PlatAuMenu p4 = null;
        PlatAuMenu p5 = null;
        PlatAuMenu ps1 = null;
        PlatAuMenu ps2 = null;
        PlatAuMenu ps3 = null;
        PlatAuMenu ps4 = null;
        PlatAuMenu ps5 = null;
        PlatAuMenu pe1 = null;
        PlatAuMenu pe2 = null;

        try {
            p1 = PlatFactory.creerPlat(PlatType.PLAT_MENU, 0, "PlatAuMenu0", (double)10.0F, new double[0]);
            p2 = PlatFactory.creerPlat(PlatType.PLAT_MENU, 1, "PlatAuMenu1", (double)20.0F, new double[0]);
            p3 = PlatFactory.creerPlat(PlatType.PLAT_MENU, 2, "PlatAuMenu2", (double)30.0F, new double[0]);
            p4 = PlatFactory.creerPlat(PlatType.PLAT_MENU, 3, "PlatAuMenu3", (double)40.0F, new double[0]);
            p5 = PlatFactory.creerPlat(PlatType.PLAT_MENU, 4, "PlatAuMenu4", (double)50.0F, new double[0]);
            ps1 = PlatFactory.creerPlat(PlatType.PLAT_SANTE, 10, "PlatSante0", (double)10.0F, new double[]{(double)11.0F, (double)11.0F, (double)11.0F});
            ps2 = PlatFactory.creerPlat(PlatType.PLAT_SANTE, 11, "PlatSante1", (double)20.0F, new double[]{(double)11.0F, (double)11.0F, (double)11.0F});
            ps3 = PlatFactory.creerPlat(PlatType.PLAT_SANTE, 12, "PlatSante2", (double)30.0F, new double[]{(double)11.0F, (double)11.0F, (double)11.0F});
            ps4 = PlatFactory.creerPlat(PlatType.PLAT_SANTE, 13, "PlatSante3", (double)40.0F, new double[]{(double)11.0F, (double)11.0F, (double)11.0F});
            ps5 = PlatFactory.creerPlat(PlatType.PLAT_SANTE, 14, "PlatSante4", (double)50.0F, new double[]{(double)11.0F, (double)11.0F, (double)11.0F});
            pe1 = PlatFactory.creerPlat(PlatType.PLAT_ENFANT, 20, "Poulet Enfant", (double)8.0F, new double[]{(double)0.5F});
            pe2 = PlatFactory.creerPlat(PlatType.PLAT_ENFANT, 21, "Poutine Enfant", (double)9.0F, new double[]{0.6});
        } catch (MenuException e) {
            System.out.println("Erreur fatale d'initialisation : " + e.getMessage());
            return;
        }

        Menu m1 = new Menu("menufact.Menu 1");
        Menu m2 = new Menu("menufact.Menu 2");
        new Facture("Ma facture");
        Client c1 = new Client(1, "Mr Client", "1234567890");
        t.test1_AffichePlatsAuMenu(trace, p1, p2, p3, p4, p5);
        t.test2_AffichePlatsSante(trace, ps1, ps2, ps3, ps4, ps5);
        t.test4_AjoutPlatsAuMenu(trace, m1, p1, p2, ps1, ps2, pe1, m2, p3, p4, ps3, ps4, pe2);

        try {
            t.test5_DeplacementMenuAvancer(m1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test6_DeplacementMenuReculer(m1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        t.test10_VerifierSingletonInventaire();

        try {
            t.test11_VerifierCompositionEtInventaire(p1, pe1);
        } catch (Exception e) {
            System.out.println("Erreur durant test11: " + e.getMessage());
        }

        Facture f2 = new Facture("Facture Post-Inventaire");
        f2.attacher(new Chef("Bob"));
        t.test8_AjouterClientFacture(f2, c1);

        try {
            t.test7_CreerFacture(f2, m1);
            t.test8_AjouterPlatsFacture(f2, m1, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        t.test12_VerifierTransitionsFacture(f2);
        t.test13_VerifierObserverEtEtats(p1);
        t.test14_VerifierFacade(c1, m1);

        try {
            t.test9_PayerFacture(f2);
        } catch (FactureException fe) {
            System.out.println(fe.getMessage());
        }

        try {
            f2.ouvrir();
        } catch (FactureException fe) {
            System.out.println("Exception attendue levée avec succès (Facture payée ne peut pas réouvrir) : " + fe.getMessage());
        }

        System.out.println("FIN DE TOUS LES TESTS...");
        FactureView vue = new FactureView();
        System.out.println(vue.genererFactureTexte(f2));
    }

    private void test1_AffichePlatsAuMenu(boolean trace, PlatAuMenu p1, PlatAuMenu p2,
                                                 PlatAuMenu p3, PlatAuMenu p4, PlatAuMenu p5)
    {
        System.out.println("=== test1_AffichePlatsAuMenu");
        if(trace)
        {
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);
            System.out.println(p5);
        }
    }


    private void test2_AffichePlatsSante(boolean trace, PlatAuMenu ps1, PlatAuMenu ps2, PlatAuMenu ps3, PlatAuMenu ps4, PlatAuMenu ps5) {
        System.out.println("=== test2_AffichePlatsSante");
        if (trace) {
            System.out.println(ps1);
            System.out.println(ps2);
            System.out.println(ps3);
            System.out.println(ps4);
            System.out.println(ps5);
        }

    }


    private static void test3_AjoutMenu(boolean trace, Menu m1, Menu m2)
    {

        System.out.println("=== test3_AjoutMenu");

        if(trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }


    private void test4_AjoutPlatsAuMenu(boolean trace, Menu m1, PlatAuMenu p1, PlatAuMenu p2, PlatAuMenu ps1, PlatAuMenu ps2, PlatAuMenu pe1, Menu m2, PlatAuMenu p3, PlatAuMenu p4, PlatAuMenu ps3, PlatAuMenu ps4, PlatAuMenu pe2) {
        System.out.println("=== test4_AjoutPlatsAuMenu");
        m1.ajoute(p1);
        m1.ajoute(p2);
        m1.ajoute(ps1);
        m1.ajoute(ps2);
        m1.ajoute(pe1);
        m2.ajoute(p3);
        m2.ajoute(p4);
        m2.ajoute(ps3);
        m2.ajoute(ps4);
        m2.ajoute(pe2);
    }


    private void test5_DeplacementMenuAvancer(Menu m1) throws MenuException
    {
        System.out.println("=== test5_DeplacementMenuAvancer");

        System.out.println("===Selectionner un plat du menu 0");
        m1.position(0);

        System.out.println("=== Afficher le plat courant");
        System.out.println(m1.platCourant());
        try {

            System.out.println("=== Avancer le plat courant");
            System.out.println("1.");
            m1.positionSuivante();
            System.out.println("2.");
            m1.positionSuivante();
            System.out.println("3.");
            m1.positionSuivante();
            System.out.println("4.");
            m1.positionSuivante();
            System.out.println("5.");
            m1.positionSuivante();
        }
        catch (MenuException me)
        {
                throw me;
        }
    }


    private void test6_DeplacementMenuReculer(Menu m1) throws MenuException
    {
        System.out.println("===test6_DeplacementMenuReculer");

        System.out.println("===Selectionner un plat du menu 3");
        m1.position(3);

        System.out.println("=== Afficher le plat courant");
        System.out.println(m1.platCourant());
        try {

            System.out.println("=== Reculer le plat courant");
            System.out.println("2.");
            m1.positionPrecedente();
            System.out.println("1.");
            m1.positionPrecedente();
            System.out.println("0.");
            m1.positionPrecedente();
            System.out.println("-1.");
            m1.positionPrecedente();
            System.out.println("-2.");
            m1.positionPrecedente();
        }
        catch (MenuException me)
        {
            throw me;
        }
    }

    private void test7_CreerFacture(Facture f1, Menu m1) throws FactureException
    {
        System.out.println("===test7_CreerFacture");

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5);
        try
        {
            f1.ajoutePlat(platChoisi);
        }
        catch (FactureException fe)
        {
            throw fe;
        }
        System.out.println(f1);
    }


    private void test8_AjouterClientFacture(Facture f1,Client c1) {
        System.out.println("===test8_AjouterClientFacture");
        f1.associerClient(c1);
        System.out.println(f1);
    }
    private void test8_AjouterPlatsFacture(Facture f1, Menu m1, int pos) throws MenuException,FactureException
    {
        System.out.println("===test8_AjouterPlatsFacture");

        try{
            for (int i=0; i< pos; i++)
                m1.positionSuivante();
        }
        catch (MenuException me)
        {
            throw me;
        }

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5);
        try
        {
            f1.ajoutePlat(platChoisi);
        }
        catch (FactureException fe)
        {
            throw fe;
        }
        System.out.println(f1);
    }

    private void test9_PayerFacture(Facture f1) throws FactureException {
        System.out.println("=== test9_PayerFacture");
        f1.fermer();
        f1.payer();
    }
    private void test10_VerifierSingletonInventaire() {
        System.out.println("=== test10_VerifierSingletonInventaire");

        InventaireService premiereInstance = InventaireService.getInstance();
        InventaireService deuxiemeInstance = InventaireService.getInstance();

        boolean memeObjet = premiereInstance == deuxiemeInstance;

        System.out.println(
                memeObjet
                        ? "SUCCÈS : Une seule instance du service existe."
                        : "ÉCHEC : Plusieurs instances du Singleton ont été créées."
        );
    }
    private final Ingredient ingredientBanane = new Fruit("Banane");
    private final Ingredient ingredientLait = new Laitier("lait");

    private void test11_VerifierCompositionEtInventaire(
            PlatAuMenu platDisponible,
            PlatAuMenu platSansStock) throws Exception {

        System.out.println("=== test11_VerifierCompositionEtInventaire");

        InventaireService inventaire = InventaireService.getInstance();

        inventaire.ajouterIngredientInventaire(
                new IngredientInventaire(ingredientBanane, 5));

        inventaire.ajouterIngredientInventaire(
                new IngredientInventaire(ingredientLait, 0));

        platDisponible.ajouterIngredientRecette(ingredientBanane, 2);
        platSansStock.ajouterIngredientRecette(ingredientLait, 1);

        Facture facture = new Facture("Validation Inventaire");

        try {
            facture.ajoutePlat(new PlatChoisi(platDisponible, 1));
            System.out.println(
                    "SUCCÈS : Le plat avec ingrédients disponibles a été ajouté.");
        } catch (FactureException e) {
            System.out.println(
                    "ÉCHEC : Le système a refusé un plat pourtant valide.");
        }

        try {
            facture.ajoutePlat(new PlatChoisi(platSansStock, 1));
            System.out.println(
                    "ÉCHEC : Le système a accepté un plat sans stock.");
        } catch (FactureException e) {
            System.out.println(
                    "SUCCÈS ATTENDU : Ajout refusé -> " + e.getMessage());
        }
    }

    private void test12_VerifierTransitionsFacture(Facture facture) {
        System.out.println("=== test12_VerifierTransitionsFacture");

        try {
            System.out.println("Paiement d'une facture non fermée...");
            facture.payer();

            System.out.println(
                    "ÉCHEC : Le paiement a été autorisé alors qu'il ne devait pas l'être.");

        } catch (FactureException e) {

            System.out.println(
                    "SUCCÈS ATTENDU : Transition interdite détectée : "
                            + e.getMessage());
        }
    }

    private void test13_VerifierObserverEtEtats(PlatAuMenu plat) {

        System.out.println("=== test13_VerifierObserverEtEtats");

        plat.getRecette().clear();

        Facture facture = new Facture("Cuisine");
        Chef chef = new Chef("Bob");

        facture.attacher(chef);

        PlatChoisi commande = new PlatChoisi(plat, 2);

        System.out.println("État initial : " + commande.getEtat().getNom());

        if (commande.getEtat() instanceof Commande) {
            System.out.println("SUCCÈS : Le plat commence bien à l'état Commandé.");
        } else {
            System.out.println("ÉCHEC : Mauvais état initial.");
        }

        try {
            facture.ajoutePlat(commande);
        } catch (FactureException e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }

        System.out.println("Après notification du chef : "
                + commande.getEtat().getNom());

        boolean estEnPreparation =
                commande.getEtat() instanceof EnPreparation;

        System.out.println(
                estEnPreparation
                        ? "SUCCÈS : L'observer a modifié l'état."
                        : "ÉCHEC : L'observer n'a rien fait."
        );

        commande.avancerEtat();
        System.out.println("Nouvel état : " + commande.getEtat().getNom());

        commande.avancerEtat();
        System.out.println("Nouvel état : " + commande.getEtat().getNom());

        commande.setEtat(new ImpossibleServir());

        System.out.println(
                "État forcé (rupture de stock) : "
                        + commande.getEtat().getNom());
    }

    private void test14_VerifierFacade(Client client, Menu menu) {

        System.out.println("=== test14_VerifierFacade");

        try {
            InventaireService.getInstance()
                    .ajouterIngredientInventaire(
                            new IngredientInventaire(ingredientBanane, 50));
        } catch (Exception e) {
            System.out.println("Impossible d'alimenter l'inventaire : "
                    + e.getMessage());
        }

        MenuFactFacade facade = new MenuFactFacade();

        Facture facture = facade.preparerNouvelleFacture(client, menu);

        boolean factureValide =
                facture != null && facture.getClient() == client;

        if (factureValide) {
            System.out.println(
                    "SUCCÈS : La façade a créé et configuré la facture.");
        } else {
            System.out.println(
                    "ÉCHEC : La facture retournée n'est pas valide.");
        }

        try {

            PlatChoisi choix =
                    new PlatChoisi(menu.platCourant(), 1);

            facture.ajoutePlat(choix);

            if (choix.getEtat() instanceof EnPreparation) {
                System.out.println(
                        "SUCCÈS : Le chef enregistré par la façade est actif.");
            } else {
                System.out.println(
                        "ÉCHEC : Aucun changement d'état détecté.");
            }

        } catch (Exception e) {

            System.out.println(
                    "Erreur lors du test de la façade : "
                            + e.getMessage());
        }
    }
}
