package application;

public class Infos {

	private String date;
	private int ha;
	private int mina;
	private int hd;
	private int mind;
	
	public Infos(String date, int ha, int mina, int hd, int mind) throws Exception {
		this.date = date;
		if(ha > 23 || ha <0) {
			throw new Exception("Nombres heures incorrect");
		}
		if(mina > 59 || mina <0) {
			throw new Exception("Nombres minutes incorrect");
		}
		this.ha = ha;
		this.mina = mina;
		this.hd = hd;
		this.mind = mind;
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
	
	
	
	

}
