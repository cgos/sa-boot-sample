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
import org.springframework.web.bind.annotation.RequestBody;
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

	private static Logger LOGGER = LoggerFactory.getLogger(LeagueController.class);

	@Autowired
	private LeagueRepository leagueRepository;

	@Autowired
	LeagueResourceAssembler resourceAssembler;

	@Autowired
	LeaguePagedResourcesAssembler pagedResourcesAssembler;

	@RequestMapping(method = RequestMethod.POST)
	public LeagueResource createLeague(@RequestBody LeagueEntity body) {
		LOGGER.info("createLeague " + "\n body:" + body);
		LeagueEntity le = leagueRepository.save(body);
		return new LeagueResource(le);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{leagueId}")
	public LeagueResource updateLeague(@PathVariable Integer leagueId, @RequestBody LeagueEntity body) {
		LOGGER.info("updateLeague /{leagueId}+ " + leagueId + "\n body:" + body);
		LeagueEntity le = leagueRepository.findOne(leagueId);
		le.setLeagueEntityName(body.getLeagueEntityName());
		le = leagueRepository.save(le);
		return new LeagueResource(le);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{leagueId}")
	public LeagueResource readLeague(@PathVariable Integer leagueId) {
		LOGGER.info("readLeague /{leagueId}=" + leagueId);
		LeagueEntity le = leagueRepository.findOne(leagueId);
		return new LeagueResource(le);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/leagues", produces = { "application/json" })
	public PagedResources<LeagueResource> readLeagues(Pageable pageable) {
		LOGGER.info("readLeagues /leagues");
		Page<LeagueEntity> leagueEntities = leagueRepository.findAll(pageable);
		return pagedResourcesAssembler.toResource(leagueEntities, resourceAssembler);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{leagueId}")
	public void deleteLeague(@PathVariable Integer leagueId) {
		LOGGER.info("deleteLeague /{leagueId}=" + leagueId);
		leagueRepository.delete(leagueId);
	}
}
