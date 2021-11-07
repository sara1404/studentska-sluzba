package model;

import java.util.ArrayList;

public class Katedra {
	private String sifraKatedre;
	private String nazivKatedre;
	private Profesor sefKatedre;
	ArrayList<Profesor> profesoriNaKatedri;
	public Katedra(String sifraKatedre, String nazivKatedre, Profesor sefKatedre,
			ArrayList<Profesor> profesoriNaKatedri) {
		super();
		this.sifraKatedre = sifraKatedre;
		this.nazivKatedre = nazivKatedre;
		this.sefKatedre = sefKatedre;
		this.profesoriNaKatedri = profesoriNaKatedri;
	}
	public String getSifraKatedre() {
		return sifraKatedre;
	}
	public void setSifraKatedre(String sifraKatedre) {
		this.sifraKatedre = sifraKatedre;
	}
	public String getNazivKatedre() {
		return nazivKatedre;
	}
	public void setNazivKatedre(String nazivKatedre) {
		this.nazivKatedre = nazivKatedre;
	}
	public Profesor getSefKatedre() {
		return sefKatedre;
	}
	public void setSefKatedre(Profesor sefKatedre) {
		this.sefKatedre = sefKatedre;
	}
	public ArrayList<Profesor> getProfesoriNaKatedri() {
		return profesoriNaKatedri;
	}
	public void setProfesoriNaKatedri(ArrayList<Profesor> profesoriNaKatedri) {
		this.profesoriNaKatedri = profesoriNaKatedri;
	}
	
	
	
}
