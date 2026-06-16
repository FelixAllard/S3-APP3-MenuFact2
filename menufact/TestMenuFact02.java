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

        t.test10_ValidationSingletonInventaire();

        try {
            t.test11_ValidationCompositionEtStocks(p1, pe1);
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

        t.test12_VerificationEtatsState(f2);
        t.test13_VerificationEtatsPlatEtChef(p1);
        t.test14_ValidationFacade(c1, m1);

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
    private void test10_ValidationSingletonInventaire() {
        System.out.println("=== test10_ValidationSingletonInventaire");
        InventaireService i1 = InventaireService.getInstance();
        InventaireService i2 = InventaireService.getInstance();
        if (i1 == i2) {
            System.out.println("SUCCÈS : Les deux sont la même reference");
        } else {
            System.out.println("ÉCHEC : Le Singleton a généré deux instances distinctes !");
        }

    }
    private final Ingredient fruitBanane = new Fruit("Banane");
    private final Ingredient laitierLait = new Laitier("lait");

    private void test11_ValidationCompositionEtStocks(PlatAuMenu platValide, PlatAuMenu platInvalide) throws Exception {
        System.out.println("=== test11_ValidationCompositionEtStocks");
        InventaireService stock = InventaireService.getInstance();
        stock.ajouterIngredientInventaire(new IngredientInventaire(this.fruitBanane, 5));
        stock.ajouterIngredientInventaire(new IngredientInventaire(this.laitierLait, 0));


        platValide.ajouterIngredientRecette(this.fruitBanane, 2);
        platInvalide.ajouterIngredientRecette(this.laitierLait, 1);
        Facture fTest = new Facture("Facture Test Stocks");

        try {
            fTest.ajoutePlat(new PlatChoisi(platValide, 1));
            System.out.println("SUCCÈS : Le plat contenant du Boeuf a été accepté (Assez de stock).");
        } catch (FactureException var7) {
            System.out.println("ÉCHEC : Le plat valide a été rejeté indûment.");
        }

        try {
            fTest.ajoutePlat(new PlatChoisi(platInvalide, 1));
            System.out.println("ÉCHEC : Le système a accepté d'ajouter un plat alors qu'il n'y a pas d'ingrédients !");
        } catch (FactureException e) {
            System.out.println("SUCCÈS ATTENDU : L'ajout a été bloqué correctement : " + e.getMessage());
        }

    }

    private void test12_VerificationEtatsState(Facture f) {
        System.out.println("=== test12_VerificationEtatsState");

        try {
            System.out.println("Tentative illégale de payer une facture ouverte...");
            f.payer();
            System.out.println("ÉCHEC : La facture ouverte a accepté le paiement sans être fermée.");
        } catch (FactureException e) {
            System.out.println("SUCCÈS ATTENDU : Le pattern State a bloqué le paiement direct. Raison : " + e.getMessage());
        }

    }

    private void test13_VerificationEtatsPlatEtChef(PlatAuMenu plat) {
        System.out.println("=== test13_VerificationEtatsPlatEtChef");
        plat.getRecette().clear();
        Facture fCuisine = new Facture("Suivi Cuisine");
        Chef chefCuisine = new Chef("Bob");
        fCuisine.attacher(chefCuisine);
        PlatChoisi pc = new PlatChoisi(plat, 2);
        System.out.println("État à l'envoi de la commande : " + pc.getEtat().getNom());
        if (pc.getEtat() instanceof Commande) {
            System.out.println("SUCCÈS : L'état initial est bien 'Commandé'.");
        } else {
            System.out.println("ÉCHEC : L'état initial est incorrect.");
        }

        try {
            fCuisine.ajoutePlat(pc);
        } catch (FactureException e) {
            System.out.println("Erreur imprévue : " + e.getMessage());
        }

        System.out.println("Étape Cuisine 1 (Après notification) : " + pc.getEtat().getNom());
        if (pc.getEtat() instanceof EnPreparation) {
            System.out.println("SUCCÈS : Le Chef (Observer) a intercepté la facture et mis le plat 'En préparation' !");
        } else {
            System.out.println("ÉCHEC : L'Observer n'a pas changé l'état automatiquement.");
        }

        pc.avancerEtat();
        System.out.println("Étape Cuisine 2 : " + pc.getEtat().getNom());
        pc.avancerEtat();
        System.out.println("Étape Cuisine 3 : " + pc.getEtat().getNom());
        System.out.println("Vérification de l'état d'erreur de stock...");
        pc.setEtat(new ImpossibleServir());
        System.out.println("Statut critique : " + pc.getEtat().getNom());
    }

    private void test14_ValidationFacade(Client client, Menu menu) {
        System.out.println("=== test14_ValidationFacade");

        try {
            InventaireService.getInstance().ajouterIngredientInventaire(new IngredientInventaire(this.fruitBanane, 50));
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout des ingrédients: " + e.getMessage());
        }

        MenuFactFacade facade = new MenuFactFacade();
        Facture fFacade = facade.preparerNouvelleFacture(client, menu);
        System.out.println("Vérification de la facture créée par la Façade...");
        if (fFacade != null && fFacade.getClient() == client) {
            System.out.println("SUCCÈS : La Façade a correctement initialisé la facture et associé le client.");
        } else {
            System.out.println("ÉCHEC : La Façade n'a pas configuré la facture correctement.");
        }

        try {
            PlatChoisi pc = new PlatChoisi(menu.platCourant(), 1);
            fFacade.ajoutePlat(pc);
            if (pc.getEtat() instanceof EnPreparation) {
                System.out.println("SUCCÈS : L'Observer (Chef) configuré par la Façade fonctionne automatiquement lors de l'ajout.");
            } else {
                System.out.println("ÉCHEC : Le Chef attaché par la Façade n'a pas intercepté le plat.");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la validation du plat via la Façade : " + e.getMessage());
        }

    }
}
