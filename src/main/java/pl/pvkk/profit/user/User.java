package pl.pvkk.profit.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="User_account")
public class User {

	@Id
	@Length(min = 5, max = 30)
	private String login;
	@Email
	private String email;
	@Length(min = 5, max = 255)
	private String password;
	@OneToOne
	private Pocket pocket;
	// default is false before user email authentication
	private boolean enabled;


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Pocket getPocket() {
		return pocket;
	}

	public void setPocket(Pocket pocket) {
		this.pocket = pocket;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", email=" + email + ", password=" + password + ", pocket=" + pocket + "]";
	}
}
