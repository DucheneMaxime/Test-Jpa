package banque;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "dateNaissance")
	private LocalDate dateNaissance;

	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "idBanque")
	private Banque banque;

	@ManyToMany(mappedBy = "clients")
	private List<Compte> comptes;

	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;
	}

	public Client() {

	}

}
