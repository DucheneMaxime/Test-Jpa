package banque;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "assurance_vie")
public class AssuranceVie extends Compte {

	@Column(name = "dateFin")
	private LocalDate dateFin;

	@Column(name = "taux")
	private double taux;

	public AssuranceVie(String numero, double solde, List<Operation> operations, List<Client> clients,
			LocalDate dateFin, double taux) {
		this.setNumero(numero);
		this.setSolde(solde);
		this.setOperations(operations);
		this.setClients(clients);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	public AssuranceVie() {

	}

}
