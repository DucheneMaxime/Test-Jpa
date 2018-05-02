package banque;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable
public class Adresse {

	private Integer numero;

	private String rue;

	private Integer codePostal;

	private String ville;

	public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Adresse() {

	}

}
