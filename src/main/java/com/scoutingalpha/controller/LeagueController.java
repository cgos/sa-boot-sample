/**
 * 
 */
package com.scoutingalpha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scoutingalpha.jpa.entity.LeagueEntity;
import com.scoutingalpha.jpa.repository.LeagueRepository;
import com.scoutingalpha.resource.LeagueResource;

/**
 * @author gosselinchristian
 *
 */
@RestController
@RequestMapping("/League")
public class LeagueController {

	private static Logger LOGGER = LoggerFactory
			.getLogger(LeagueController.class);

	@Autowired
	private LeagueRepository leagueRepository;

	@Autowired
	LeagueResourceAssembler resourceAssembler;

	@Autowired
	LeaguePagedResourcesAssembler pagedResourcesAssembler;

	/**
	 * 
	 * @param leagueId
	 * @return
	 */
	@RequestMapping(value = "/{leagueId}", method = RequestMethod.GET)
	public LeagueResource readLeague(@PathVariable Integer leagueId) {
		LOGGER.info("readLeague");
		System.out.println("ALLLOOO: " + leagueId);
		LeagueEntity le = leagueRepository.findOne(leagueId);
		return new LeagueResource(le);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" }, value = "/leagues")
	public PagedResources<LeagueResource> readLeagues(Pageable pageable) {
		Page<LeagueEntity> leagueEntities = leagueRepository.findAll(pageable);
		return pagedResourcesAssembler.toResource(leagueEntities,
				resourceAssembler);
	}
}
