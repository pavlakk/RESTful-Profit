package pl.pvkk.profit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

import pl.pvkk.profit.gpw.GpwSharesDownloader;
import pl.pvkk.profit.user.User;
import pl.pvkk.profit.user.UserService;

@Configuration
@Profile("prod")
public class InitDatabase {

	@Autowired
	private GpwSharesDownloader downloader;
	
	@Autowired
	private UserService userService;
	
	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		downloader.addShares();
		userService.tryToSaveUser(makeFirstUser());
	}
	
	private User makeFirstUser() {
		User user = new User();
		user.setEmail("asdasd@asd.asd");
		user.setLogin("login");
		user.setPassword("password");
		user.setEnabled(true);
		return user;
	}
}
