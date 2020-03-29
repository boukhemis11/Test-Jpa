/**
 * 
 */
package banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author boukh
 *
 */
public class TestBanque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Banque banque = new Banque("La Banque Postale");
		Adresse adresse1 = new Adresse(11, "square notre dame d'afrique", 13010, "Marseille");
		Adresse adresse2 = new Adresse(11, "Rue les abbatoire", 13015, "Marseille");

		ClientBanque client1 = new ClientBanque("Boukhemis", "Dib", LocalDate.now(),adresse1, banque);
		ClientBanque client2 = new ClientBanque("Wiam", "Dib", LocalDate.now(),adresse2, banque);
		
		Operation ope1 = new Operation();

		Compte compte1 = new Compte("compte1",20000, Arrays.asList(client1),Arrays.asList(ope1));
		Compte compte2 = new Compte("compte2",5000, Arrays.asList(client1, client2),Arrays.asList(ope1));
		Compte livretA = new LivertA("1241235435",23891, Arrays.asList(client2),Arrays.asList(ope1), 1.0);
		Compte assuranceVie = new AssuranceVie("8767776576",10000, Arrays.asList(client1), LocalDate.now(), 1.0);

		Operation ope2 = new Operation(LocalDateTime.now(), 500.0, "Credit", compte2);
		Operation ope3 = new Operation(LocalDateTime.now(), 50.0, "Debit", compte1);
		Operation virement = new Virement(LocalDateTime.now(), 500.0, "Debit", compte1, "Médor");

		client1.addCompte(compte1);
		client2.addCompte(compte2);
		client2.addCompte(livretA);
		client1.addCompte(assuranceVie);

		compte1.addOperation(virement);
		compte2.addOperation(ope2);
		compte2.addOperation(ope3);

		EntityTransaction t1 = entityManager.getTransaction();

		t1.begin();

		Arrays.asList(banque, client1, client2, compte1, compte2, livretA, assuranceVie, ope1, ope2, virement)
				.forEach(entityManager::persist);

		t1.commit();

		TypedQuery<ClientBanque> query1 = entityManager.createQuery("Select c FROM Client c", ClientBanque.class);

		for (ClientBanque client : query1.getResultList()) {
				System.out.println(client);
		}

		TypedQuery<Compte> query2 = entityManager.createQuery("Select c FROM Compte c", Compte.class);

		for (Compte compte : query2.getResultList()) {
			System.out.println(compte);
		}


		// transaction 2
		EntityTransaction t2 = entityManager.getTransaction();

		t2.begin();

		entityManager.persist(ope3);
		entityManager.persist(assuranceVie);
		entityManager.persist(livretA);

		t2.commit();


		entityManager.close();

		entityManagerFactory.close();

	}

}
