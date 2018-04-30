package biblio;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "livre")
public class Livre {
	@Id
	private Integer id;

	@Column(name = "TITRE", length = 255, nullable = false)
	private String titre;

	@Column(name = "AUTEUR", length = 50, nullable = false)
	private String auteur;

	@ManyToMany(mappedBy = "livres")
	private Set<Emprunt> emprunts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}
}
