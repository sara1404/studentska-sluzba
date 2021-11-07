package model;

import java.util.Date;

enum VrednostOcene {
	SEST(6), SEDAM(7), OSAM(8), DEVET(9), DESET(10);
	int vrOcene;
		VrednostOcene(int i) { this.vrOcene = i; }  
	public int getValue() {
		return vrOcene;
	}
};


public class Ocena {
	private Student student;
	private Predmet predmet;
	private VrednostOcene ocena;
	private Date datumPolaganja;
	
	public Ocena(Student student, Predmet predmet, VrednostOcene ocena, Date datumPolaganja) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.ocena = VrednostOcene.SEDAM;
		this.datumPolaganja = datumPolaganja;
		
		//moguca provera za opseg ocene, razmotriti jos
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public VrednostOcene getOcena() {
		return ocena;
	}
	public void setOcena(VrednostOcene ocena) {
		this.ocena = ocena;
	}
	public Date getDatumPolaganja() {
		return datumPolaganja;
	}
	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}
	
	
}	
