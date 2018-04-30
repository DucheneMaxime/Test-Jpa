package biblio;

import java.util.Iterator;
import java.util.Set;

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

			// TP 02
			// System.out.println(trouverLivreViaId(1).toString());
			// System.out.println(trouverLivreViaTitre("Germinal").toString());

			// TP 03
			Set<Livre> livres = trouverLivresDEmprunt(1);
			Iterator it = livres.iterator();
			while (it.hasNext()) {
				System.out.println(it.next().toString());
			}
			Set<Emprunt> emprunts = trouverEmpruntsDeClient(1);
			Iterator it2 = emprunts.iterator();
			while (it2.hasNext()) {
				System.out.println(it2.next().toString());
			}

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

	public static Set<Livre> trouverLivresDEmprunt(int id) {
		Emprunt emp = em.find(Emprunt.class, id);
		return emp.getLivres();
	}

	public static Set<Emprunt> trouverEmpruntsDeClient(int id) {
		return em.find(Client.class, id).getEmprunts();

	}

}
