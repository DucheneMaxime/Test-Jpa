package banque;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "compte")
public abstract class Compte {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "numero")
	private String numero;

	@Column(name = "solde")
	private double solde;

	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;

	@ManyToMany
	@JoinTable(name = "COM_CLI", joinColumns = @JoinColumn(name = "ID_COM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"))
	private List<banque.Client> clients;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

}
