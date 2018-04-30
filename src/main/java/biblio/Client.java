package biblio;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	private Integer id;

	@Column(name = "NOM", length = 50)
	private String nom;

	@Column(name = "PRENOM", length = 50)
	private String prenom;

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	@OneToMany(mappedBy = "client")
	private Set<Emprunt> emprunts;

}
