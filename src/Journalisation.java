import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Journalisation {
    private static final Object object = new Object();
    private static Journalisation _instance;
    private String journal; //Chaine de caractères représentant les messages de log.

    private Journalisation(){
        this.journal= "";
    }

    public static synchronized Journalisation getInstance(){
        if (_instance==null){
            _instance=new Journalisation();
        }
        synchronized (object) {
            if (_instance == null) {
                _instance = new Journalisation();
            }
        return _instance;
    }

    // Méthode qui permet d'ajouter un message de log.
    public void ajouterLog(String journal)
    {
        // On ajoute également la date du message.
        Date d = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH'h'mm");
        this.journal+="["+dateFormat.format(d)+"] "+journal+"\n";
    }
    // Méthode qui retourne tous les messages de log.
    public String afficherLog()
    {
        return journal;
    }
}
