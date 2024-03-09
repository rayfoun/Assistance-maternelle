package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MonController {
	@FXML
    private Label lbInfo;

    @FXML
    private Label lbIndice;

    @FXML
    private TextField tfNomPrenom;

    @FXML
    private TextField tfDate;

    @FXML
    private TextField tfHeureArrivee;

    @FXML
    private TextField tfHeureDepart;

    @FXML
    private Button btAjouterHD;
    
    public static int i=0;
    
    public static boolean createPresence = true;
    
    
    @FXML
    private void initialize() {
    	System.out.println("Démarrage");
    }
    
    @FXML
    void actionAjouterHA(ActionEvent evt) throws NumberFormatException, Exception {
    	System.out.println("actionAjouterHA");
    	
    	String nom_prenom;
		String date;
		String heures_minutes;
		nom_prenom = tfNomPrenom.getText();
		date = tfDate.getText();
		heures_minutes = tfHeureArrivee.getText();
    	
    	String[] valeurs1;
		try {
			valeurs1 = nom_prenom.split(" ");
			if(valeurs1.length != 2) {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			lbInfo.setText("erreur Nom Prenom");
			tfNomPrenom.setText("");
			tfDate.setText("");
			tfHeureArrivee.setText("");
			return;
		}
    	String[] valeurs2;
		try {
			valeurs2 = heures_minutes.split(":");
			if(valeurs2.length != 2) {
				throw new Exception("heure au format HH:MM");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			lbInfo.setText(e.getMessage());
			tfHeureArrivee.setText("");
			return;
		}
		
		int var1;
		int var2;
		try {
			var1 = Integer.parseInt(valeurs2[0]);
			var2 = Integer.parseInt(valeurs2[1]);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			lbInfo.setText("Erreur HH et MM sont des nombres");
			tfHeureArrivee.setText("");
			return;
		}
		
		if(tfDate.getText() == "") {
			lbInfo.setText("Erreur entrer la date");
			return;
		}
    	
    	tfNomPrenom.setDisable(true);
    	tfHeureDepart.setText("");
    	
    	try {
			if(Presence.listePresence.size() != 1) {
				Presence p = new Presence(valeurs1[0], valeurs1[1], date, var1, var2);
			}
			Presence.listePresence.get(0).getListeInfosPresences().add(new Infos(date, var1, var1, 0, 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			lbInfo.setText(e.getMessage());
			return;
		}
		lbInfo.setText("Ajouter heure d’arrivée");
		btAjouterHD.setDisable(false);
    	i=Presence.listePresence.get(0).getListeInfosPresences().size();
    	
    	lbIndice.setText(Presence.listePresence.get(0).getListeInfosPresences().size() + "/" + Presence.listePresence.get(0).getListeInfosPresences().size());
    	
    	
    	
    }
    
    @FXML
    void actionAjouterHD(ActionEvent evt) {
    	System.out.println("actionAjouterHD");
    	String dep = tfHeureDepart.getText();
    	
    	String tab[] = dep.split(":");
    	
    	
    	
    	for (int j=0; j < Presence.listePresence.get(0).getListeInfosPresences().size(); j++) {
    		if(j==(i-1)) {
    			Presence.listePresence.get(0).getListeInfosPresences().get(j).setHd(Integer.parseInt(tab[0]));
    			Presence.listePresence.get(0).getListeInfosPresences().get(j).setMind(Integer.parseInt(tab[1]));
    		}
		}
		
    	
//    	Infos.listeInfos.get(0).setHd(Integer.parseInt(tab[0]));
//    	Infos.listeInfos.get(0).setMind(Integer.parseInt(tab[1]));
    	
    	System.out.println(Presence.listePresence.get(0).getListeInfosPresences().get(0).getHd());
    	System.out.println(Presence.listePresence.get(0).getListeInfosPresences().get(0).getMind());
    	
    	lbInfo.setText("Ajouter heure de départ");
    }
    
    @FXML
    void actionAvant(ActionEvent evt) {
    	System.out.println("actionAvant");
    	if(i != 0) {
    		System.out.println("fine");
    		tfDate.setText(Presence.listePresence.get(0).getListeInfosPresences().get(i-1).getDate());
    		tfHeureArrivee.setText(Presence.listePresence.get(0).getListeInfosPresences().get(i-1).getHa() + ":" + Presence.listePresence.get(0).getListeInfosPresences().get(i-1).getMina());
    		tfHeureDepart.setText(Presence.listePresence.get(0).getListeInfosPresences().get(i-1).getHd() + ":" + Presence.listePresence.get(0).getListeInfosPresences().get(i-1).getMind());
    		lbIndice.setText(i + "/" + Presence.listePresence.get(0).getListeInfosPresences().size());
    		i--;
    		
//    		tfDate.setText(Infos.listeInfos.get(i-1).getDate());
//    		tfHeureArrivee.setText(Infos.listeInfos.get(i-1).getHa() + ":" + Infos.listeInfos.get(i-1).getMina());
//    		tfHeureDepart.setText(Infos.listeInfos.get(i-1).getHd() + ":" + Infos.listeInfos.get(i-1).getMind());
//    		lbIndice.setText(i + "/" + Infos.listeInfos.size());
//    		i--;
    	}
    	
    	
    }
    
    @FXML
    void actionApres(ActionEvent evt) {
    	System.out.println("actionApres");
    	
    	if(i != Presence.listePresence.get(0).getListeInfosPresences().size()) {
    		
    		tfDate.setText(Presence.listePresence.get(0).getListeInfosPresences().get(i).getDate());
    		tfHeureArrivee.setText(Presence.listePresence.get(0).getListeInfosPresences().get(i).getHa() + ":" + Presence.listePresence.get(0).getListeInfosPresences().get(i).getMina());
    		tfHeureDepart.setText(Presence.listePresence.get(0).getListeInfosPresences().get(i).getHd() + ":" + Presence.listePresence.get(0).getListeInfosPresences().get(i).getMind());
    		lbIndice.setText(i+1 + "/" + Presence.listePresence.get(0).getListeInfosPresences().size());
    		i++;
    	
    		
//    		tfDate.setText(Infos.listeInfos.get(i).getDate());
//    		tfHeureArrivee.setText(Infos.listeInfos.get(i).getHa() + ":" + Infos.listeInfos.get(i).getMina());
//    		tfHeureDepart.setText(Infos.listeInfos.get(i).getHd() + ":" + Infos.listeInfos.get(i).getMind());
//    		lbIndice.setText(i+1 + "/" + Infos.listeInfos.size());
//    		i++;
    	}
    }
    
}
