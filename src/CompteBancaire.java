public class CompteBancaire {
    private String numero;
    public Double solde;

    public CompteBancaire(String numero){
        this.numero=numero;
        this.solde=0.0;
    }

    // Méthode qui permet de déposer de l'argent sur le compte.
    public void depot(Double montant){
        if (montant>0.0){
            this.solde+=montant;
            Journalisation.getInstance().ajouterLog("Dépôt de "+montant+"€ sur le compte "+numero+".");
        }
        else {
            Journalisation.getInstance().ajouterLog("/!\\ Dépôt d'une valeur négative impossible ("+numero+").");
        }
    }
    // Méthode qui permet de retirer de l'argent sur le compte.
    public void retrait(Double montant){
        if(montant>0.0){
            if (solde>montant){
                this.solde-=montant;
                Journalisation.getInstance().ajouterLog("Retrait de "+montant+"€ sur le compte "+numero+".");
            }
            else{
                Journalisation.getInstance().ajouterLog("/!\\ Retrait d'une valeur souperieur ou egale impossible ("+numero+").");
            }
        }
        else{
            Journalisation.getInstance().ajouterLog("/!\\ Retrait d'une valeur négative impossible ("+numero+").");
        }
    }
}
