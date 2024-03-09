package application;

import java.util.ArrayList;

public class Presence {

	public static ArrayList<Presence> listePresence = new ArrayList<Presence>();
	
	private ArrayList<Infos> listeInfosPresences = new ArrayList<Infos>();
	private String nom;
	private String prenom;
	private String date;
	private int ha;
	private int mina;
	private int hd;
	private int mind;
	
	public Presence(String ligne) throws Exception {
		// TODO Auto-generated constructor stub
		String[] valeurs = ligne.split(" ");
		String[] valeursDate = valeurs[0].split("=");
		String[] valeursNom = valeurs[1].split("=");
		String[] valeursPrenom = valeurs[2].split("=");
		String[] valeursArrivee = valeurs[3].split("=");
		String[] valeursDepart = valeurs[4].split("=");
		
		this.date = valeursDate[1];
		this.nom = valeursNom[1];
		this.prenom = valeursPrenom[1];
		
		String[] valeursArriveeH = valeursArrivee[1].split(":");
		String[] valeursDepartH = valeursDepart[1].split(":");
		
		
		this.ha = Integer.parseInt(valeursArriveeH[0]);
		this.mina = Integer.parseInt(valeursArriveeH[1]);
		this.hd = Integer.parseInt(valeursDepartH[0]);
		this.mind = Integer.parseInt(valeursDepartH[1]);
		
		
		listePresence.add(this); //Ajout de l'objet courant au tableau
		
		
		
		
	}

	public Presence(String nom, String prenom, String date, int ha, int mina) throws Exception {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		if(ha > 23 || ha <0) {
			throw new Exception("Nombres heures incorrect");
		}
		if(mina > 59 || mina <0) {
			throw new Exception("Nombres minutes incorrect");
		}
		this.ha = ha;
		this.mina = mina;
		
		listePresence.add(this);
		
//		for(Presence p: listePresence) {
//			if(this.nom == p.nom && this.prenom == p.prenom && this.date == date) {
//				throw new Exception("cet enfant existe déjà");
//			}
//			else {
//				listePresence.add(this);
//			}
//		}
	}
	
	
	
	//Getters et setters

	@Override
	public String toString() {
		return "DATE=" + date + " NOM=" + nom + " PRENOM=" + prenom + " ARRIVEE=" + ha + ":" + mina
				+ " DEPART=" + hd + ":" + mind ;
	}

	public static ArrayList<Presence> getListePresence() {
		return listePresence;
	}

	public static void setListePresence(ArrayList<Presence> listePresence) {
		Presence.listePresence = listePresence;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHa() {
		return ha;
	}

	public void setHa(int ha) {
		this.ha = ha;
	}

	public int getMina() {
		return mina;
	}

	public void setMina(int mina) {
		this.mina = mina;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}

	public int getMind() {
		return mind;
	}

	public void setMind(int mind) {
		this.mind = mind;
	}

	public ArrayList<Infos> getListeInfosPresences() {
		return listeInfosPresences;
	}

	public void setListeInfosPresences(ArrayList<Infos> listeInfosPresences) {
		this.listeInfosPresences = listeInfosPresences;
	}
	
	
	

}
