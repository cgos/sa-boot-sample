package com.scoutingalpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * @author gosselinchristian
 *
 */
@SpringBootApplication
@EnableSpringDataWebSupport
public class SpringBootSampleApplication  {

//	@Autowired
//	LeagueRepository leagueRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleApplication.class, args);
	}

//	@Override
//	public void run(String... strings) throws Exception {
//		leagueRepo.save(new LeagueEntity("SpringAppLeagueName"));
//	}
}