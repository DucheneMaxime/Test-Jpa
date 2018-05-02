package banque;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "banque")
public class Banque {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "nom")
	private String nom;

	@OneToMany(mappedBy = "banque")
	private List<Client> clients;

	public Banque() {

	}

	public Banque(String nom) {
		this.nom = nom;
	}

}
