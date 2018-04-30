package biblio;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprunt")
public class Emprunt {
	@Id
	private Integer id;

	@Column(name = "DATE_DEBUT")
	private LocalDate DateDebut;

	@Column(name = "DATE_FIN")
	private LocalDate DateFin;

	@Column(name = "DELAI", length = 10)
	private Integer delai;

	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;

	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private Set<Livre> livres;

	public Set<Livre> getLivres() {
		return livres;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", delai=" + delai
				+ ", client=" + client + ", livres=" + livres + "]";
	}

}
