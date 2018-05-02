package banque;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "virement")
public class Virement extends Operation {

	@Column(name = "beneficiaire")
	private String beneficiaire;

	public Virement(String beneficiaire, LocalDate date, double montant, String motif) {
		this.setDate(date);
		this.setMontant(montant);
		this.setMotif(motif);
		this.beneficiaire = beneficiaire;
	}

	public Virement() {

	}

}
