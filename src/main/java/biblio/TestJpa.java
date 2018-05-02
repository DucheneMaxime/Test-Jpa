package biblio;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import banque.Adresse;
import banque.AssuranceVie;
import banque.Banque;
import banque.Compte;
import banque.LivretA;
import banque.Operation;
import banque.Virement;

public class TestJpa {
	private static EntityManager em;

	private static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);

	public static void main(String[] args) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
			em = emf.createEntityManager();

			// TP 02
			// System.out.println(trouverLivreViaId(1).toString());
			// System.out.println(trouverLivreViaTitre("Germinal").toString());

			// TP 03
			/*
			 * Set<Livre> livres = trouverLivresDEmprunt(1); Iterator it =
			 * livres.iterator(); while (it.hasNext()) {
			 * System.out.println(it.next().toString()); } Set<Emprunt> emprunts
			 * = trouverEmpruntsDeClient(1); Iterator it2 = emprunts.iterator();
			 * while (it2.hasNext()) {
			 * System.out.println(it2.next().toString()); }
			 */

			// TP 04
			EntityTransaction et = em.getTransaction();
			et.begin();

			// Nouvelle adresse
			Adresse adresse = new Adresse(3, "rue Edith Piaf", 44000, "Saint-Herblain");
			LOG.debug("Adresse OK");

			// Nouvelle banque
			Banque banque = new Banque("Société Générale");
			em.persist(banque);
			LOG.debug("Banque OK");

			// Nouveau client
			banque.Client client = new banque.Client("Lauret", "Sony", LocalDate.of(1789, 07, 14), adresse, banque);
			em.persist(client);
			LOG.debug("Client OK");
			// Set de clients
			List<banque.Client> setClients = new LinkedList();
			setClients.add(client);

			// Nouveau virement
			Virement virement = new Virement("moi", LocalDate.now(), 500.00, "because");
			em.persist(virement);
			LOG.debug("Virement 1 OK");
			// Set de virements
			List<Operation> setVirements = new LinkedList();
			setVirements.add(virement);

			// Second virement
			Virement virement2 = new Virement("moi", LocalDate.of(2012, 12, 11), 222.22, "parce que");
			em.persist(virement2);
			LOG.debug("Virement 2 OK");
			// Second set de virements
			List<Operation> setVirements2 = new LinkedList();
			setVirements2.add(virement2);

			// Nouvelle assurance vie
			Compte assuranceVie = new AssuranceVie("123", 50.2, setVirements, setClients, LocalDate.of(2020, 01, 01),
					0.5);
			em.persist(assuranceVie);
			LOG.debug("Assurance Vie OK");

			// Nouveau Livret A
			Compte livretA = new LivretA("666", 0.01, setVirements2, setClients, 1.50);
			em.persist(livretA);
			LOG.debug("Livret A OK");

			et.commit();

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
