package model;

import java.util.ArrayList;

enum Semestar {LETNJI, ZIMSKI};

public class Predmet {
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private int godinaStudija;
	private Profesor profesor;
	private int brojESPB;
	private ArrayList<Student> studentiPolozili;
	private ArrayList<Student> studentiNisuPolozili;
	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija, Profesor profesor,
			int brojESPB, ArrayList<Student> studentiPolozili, ArrayList<Student> studentiNisuPolozili) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.brojESPB = brojESPB;
		this.studentiPolozili = studentiPolozili;
		this.studentiNisuPolozili = studentiNisuPolozili;
	}
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	public Semestar getSemestar() {
		return semestar;
	}
	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}
	public int getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public int getBrojESPB() {
		return brojESPB;
	}
	public void setBrojESPB(int brojESPB) {
		this.brojESPB = brojESPB;
	}
	public ArrayList<Student> getStudentiPolozili() {
		return studentiPolozili;
	}
	public void setStudentiPolozili(ArrayList<Student> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}
	public ArrayList<Student> getStudentiNisuPolozili() {
		return studentiNisuPolozili;
	}
	public void setStudentiNisuPolozili(ArrayList<Student> studentiNisuPolozili) {
		this.studentiNisuPolozili = studentiNisuPolozili;
	}
	
	
	
}
