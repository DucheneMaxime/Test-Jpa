package biblio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestJpa {
	private static EntityManager em;

	public static void main(String[] args) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
			em = emf.createEntityManager();
			System.out.println(trouverLivreViaId(1).toString());
			System.out.println(trouverLivreViaTitre("Germinal").toString());
		} catch (IllegalArgumentException e) {
		}
	}

	public static Livre trouverLivreViaId(Integer idSearch) {
		return em.find(Livre.class, idSearch);
	}

	public static Livre trouverLivreViaTitre(String titreSearch) {
		Query query = em.createQuery("select livre from Livre livre where livre.titre='" + titreSearch + "'");
		return (Livre) query.getSingleResult();
	}

}
