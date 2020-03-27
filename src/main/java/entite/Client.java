/**
 * 
 */
package entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author boukh
 *
 */
@Entity
@Table( name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	
	@OneToMany(mappedBy = "client")
	private Set<Emprunt> emprunts;
	
	
	public Client() {

	}
	public Client(Integer id, String nom, String prenom, Set<Emprunt> emprunts) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.emprunts = emprunts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}
	public void setEmprunts(Set<Emprunt> emprunt) {
		this.emprunts = emprunt;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", emprunts=" + emprunts + "]";
	}
	
}
