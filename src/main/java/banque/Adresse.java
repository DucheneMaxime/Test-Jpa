package banque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "adresse")
public class Adresse {
	@Id
	private Integer id;

	@Column(name = "numero", length = 10, nullable = false)
	private Integer numero;

	@Column(name = "rue", length = 255, nullable = false)
	private String rue;

	@Column(name = "codePostal")
	private Integer codePostal;

	@Column(name = "ville")
	private String ville;

	@OneToMany(mappedBy = "adresse")
	private Set<Client> clients;

}
