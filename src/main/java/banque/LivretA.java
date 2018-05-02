package banque;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livretA")
public class LivretA extends Compte {

	@Column(name = "taux")
	private double taux;

	public LivretA(String numero, double solde, List<Operation> operations, List<Client> clients, double taux) {
		this.setNumero(numero);
		this.setSolde(solde);
		this.setOperations(operations);
		this.setClients(clients);
		this.taux = taux;

	}

	public LivretA() {

	}

}
