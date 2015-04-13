/**
 * 
 */
package com.scoutingalpha.controller;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.scoutingalpha.jpa.entity.LeagueEntity;
import com.scoutingalpha.resource.LeagueResource;

/**
 * @author gosselinchristian
 *
 */
@Component
public class LeagueResourceAssembler extends ResourceAssemblerSupport<LeagueEntity, LeagueResource> {

	public LeagueResourceAssembler() {
		super(LeagueController.class, LeagueResource.class);
	}

	@Override
	public LeagueResource toResource(LeagueEntity league) {
		LeagueResource leagueResource = new LeagueResource(league);
//		return createResourceWithId(league.getId(), league);
		return leagueResource;
	}
}
