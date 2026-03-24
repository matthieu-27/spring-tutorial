package fr.fms.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.tutorial.console.App;

@SpringBootApplication
public class TutorialApplication implements CommandLineRunner {

	@Autowired
	private App appMgr;

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		appMgr.start();
	}

}
