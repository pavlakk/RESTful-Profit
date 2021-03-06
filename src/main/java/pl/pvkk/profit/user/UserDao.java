package pl.pvkk.profit.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager em;
	
	public User getUserByName(String username){
		User user = em.find(User.class, username);
		user.setPassword("not your business");
		return user;
	}
	
	public boolean isLoginTaken(String login){
		Query query = em.createQuery("SELECT COUNT(*) FROM User WHERE login = :login");
		query.setParameter("login", login);

		//return true if login is taken
		return (long) query.getSingleResult() > 0;		
	}

	public boolean isEmailTaken(String email) {
		Query query = em.createQuery("SELECT COUNT(*) FROM User WHERE email = :email");
		query.setParameter("email", email);
		return (long) query.getSingleResult() > 0;
	}
	
	public void saveUser(User user){
		Pocket pocket = new Pocket();
		pocket.setUsername(user.getLogin());
		user.setPocket(pocket);
		em.persist(user);
		em.persist(pocket);
	}

	public void setEnabledUser(User user) {
		em.merge(user);
	}
}
