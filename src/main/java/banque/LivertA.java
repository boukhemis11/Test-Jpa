/**
 * 
 */
package banque;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author boukh
 *
 */
public class LivertA extends Compte {

	@Column(name = "taux")
	private double taux;
	
	public LivertA() {
		super();
	}




	public LivertA( String numero, double solde, List<ClientBanque> clients, List<Operation> operations, double taux) {
		super(numero, solde, clients, operations);
		 this.taux =  taux;
	}




	public LivertA(String numero, double solde, List<ClientBanque> clients, List<Operation> operations) {
		super(numero, solde, clients, operations);

	}




	public Double getTaux() {
		return taux;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t- Taux : " + taux;
	}
}
