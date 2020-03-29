/**
 * 
 */
package banque;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author boukh
 *
 */
@Entity
@Table( name="client")
public class ClientBanque {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "date_naissance")
	private LocalDate DateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name = "id_banque")
	private Banque banque;
	
	@ManyToMany
	@JoinTable(name = "client_compte", joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"))
	private List<Compte> comptes;


	public ClientBanque() {
		super();
	}

	public ClientBanque(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		DateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;

	}

	public ClientBanque(Integer id, String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque,
			List<Compte> comptes) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		DateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;
		this.comptes = comptes;
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


	public LocalDate getDateNaissance() {
		return DateNaissance;
	}


	public void setDateNaissance(LocalDate dateNaissance) {
		DateNaissance = dateNaissance;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public Banque getBanque() {
		return banque;
	}


	public void setBanque(Banque banque) {
		this.banque = banque;
	}


	public List<Compte> getComptes() {
		return comptes;
	}


	public void addCompte(Compte compte) {
		comptes.add(compte);
	}


	@Override
	public String toString() {
		return "ClientBanque [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", DateNaissance=" + DateNaissance
				+ ", adresse=" + adresse + ", banque=" + banque + ", comptes=" + comptes + "]";
	}


	
	
}
