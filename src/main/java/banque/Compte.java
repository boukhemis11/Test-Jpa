/**
 * 
 */
package banque;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author boukh
 *
 */
@Entity
@Table( name="Compte")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "numero")
	private String numero;
	@Column(name = "solde")
	private double solde;
	
	@ManyToMany(mappedBy = "comptes")
	private List<ClientBanque> clients;
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;

	public Compte() {
		super();
	}
	
	public Compte(String numero, double solde, List<ClientBanque> clients, List<Operation> operations) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.clients = clients;
		this.operations = new ArrayList<Operation>();
	}
	
	public Compte(String numero, double solde, List<ClientBanque> clients) {
		super();

		this.numero = numero;
		this.solde = solde;
		this.clients = clients;

	}

	public Compte(Integer id, String numero, double solde, List<ClientBanque> clients, List<Operation> operations) {
		super();
		this.id = id;
		this.numero = numero;
		this.solde = solde;
		this.clients = clients;
		this.operations = operations;
	}
	
	public void addOperation(Operation o) {
		operations.add(o);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<ClientBanque> getClients() {
		return clients;
	}

	public void setClients(List<ClientBanque> clients) {
		this.clients = clients;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", clients=" + clients + ", operations="
				+ operations + "]";
	}
	
	
}
