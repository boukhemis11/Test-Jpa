/**
 * 
 */
package banque;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author boukh
 *
 */
public class AssuranceVie extends Compte {

	@Column(name = "dateFin")
	private LocalDate dateFin;
	@Column(name = "taux")
	private double taux;
	
	public AssuranceVie() {
		super();
	}

	public AssuranceVie(LocalDate dateFin, double taux) {
		super();
		this.dateFin = dateFin;
		this.taux = taux;
	}
	
	
	
	public AssuranceVie( String numero, double solde, List<ClientBanque> clients
			) {
		super(numero, solde, clients);
		// TODO Auto-generated constructor stub
	}

	

	public AssuranceVie(Integer id, String numero, double solde, List<ClientBanque> clients,
			List<Operation> operations) {
		super(id, numero, solde, clients, operations);
		// TODO Auto-generated constructor stub
	}

	public AssuranceVie(String numero, double solde, List<ClientBanque> clients,LocalDate dateFin, double taux) {
		super(numero, solde, clients);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t- Date de fin : " + dateFin.toString() + "\n\t- Taux : " + taux;
	}
}
