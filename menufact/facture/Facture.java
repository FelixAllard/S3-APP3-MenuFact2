package menufact.facture;

import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;

/**
 * Une facture du systeme Menufact qui agit comme le contexte
 * dans le patron de conception State.
 * @author Domingo Palao Munoz
 * @version 2.0
 */
public class Facture {
    private Date date;
    private String description;
    private FactureEtat etat;
    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private ArrayList<FactureObserver> observers = new ArrayList<>();
    private int courant;
    private Client client;

    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client)
    {
        this.client = client;
    }

    /**
     *
     * @param observer un observeur de la facture
     */
    public void attacher(FactureObserver observer) {
        observers.add(observer);
    }

    public void notifierChangement(PlatChoisi plat) throws FactureException {
        for (FactureObserver obs : observers) {
            obs.mettreAJour(plat);
        }
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal()
    {
        double soustotal=0;
        for (PlatChoisi p : platchoisi)
            soustotal += p.getQuantite() * p.getPlat().getPrix();
        return soustotal;
    }

    /**
     *
     * @return le total de la facture
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     *
     * @return la valeur de la TPS
     */
    private double tps(){
        return TPS*sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    private  double tvq(){
        return TVQ*(TPS+1)*sousTotal();
    }

    /**
     * Permet de chager l'état de la facture à PAYEE
     * @throws FactureException si le changement d'état est invalide
     */
    public void payer() throws FactureException
    {
        etat.payer(this);
    }

    /**
     * Permet de chager l'état de la facture à FERMEE
     * @throws FactureException si le changement d'état est invalide
     */
    public void fermer() throws FactureException
    {
        etat.fermer(this);
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException si la facture est PAYEE ou si le changement est invalide
     */
    public void ouvrir() throws FactureException
    {
        etat.ouvrir(this);
    }

    /**
     *
     * @return l'état de la facture
     */
    public FactureEtat getEtat()
    {
        return etat;
    }

    /**
     * Modifie l'état interne de la facture.
     * Cette méthode est accessible par les classes du package (les états) pour effectuer les transitions.
     * * @param nouvelEtat Le nouvel état à appliquer
     */
    protected void setEtat(FactureEtat nouvelEtat) {
        this.etat = nouvelEtat;
    }

    /**
     *
     * @param description la description de la Facture
     */
    public Facture(String description) {
        date = new Date();
        etat = new Ouverte(); // Initialisation avec l'état initial concret
        courant = -1;
        this.description = description;
    }

    /**
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException
    {
        notifierChangement(p);
        etat.ajoutePlat(this, p);
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<PlatChoisi> getPlatchoisi() {
        return platchoisi;
    }

    public Client getClient() {
        return client;
    }

    public double getTpsValeur() {
        return tps();
    }

    public double getTvqValeur() {
        return tvq();
    }

    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
    public String toString() {
        return "menufact.facture.Facture{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + etat + // Appelle implicitement le toString() de l'état concret ("OUVERTE", etc.)
                ", platchoisi=" + platchoisi +
                ", courant=" + courant +
                ", client=" + client +
                ", TPS=" + TPS +
                ", TVQ=" + TVQ +
                '}';
    }
}