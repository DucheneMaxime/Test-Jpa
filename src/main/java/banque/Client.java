package banque;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	private Integer id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "dateNaissance")
	private LocalDate dateNaissance;

	@ManyToOne
	@JoinColumn(name = "idAdresse")
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "idBanque")
	private Banque banque;

}
