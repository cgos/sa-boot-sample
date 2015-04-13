package com.scoutingalpha.resource;

import org.springframework.hateoas.ResourceSupport;

import com.scoutingalpha.jpa.entity.LeagueEntity;

public class LeagueResource extends ResourceSupport {
	private final LeagueEntity leagueEntity;


	public LeagueResource(LeagueEntity leagueEntity) {
		this.leagueEntity = leagueEntity;
	}

	public LeagueEntity getLeagueEntity() {
		return leagueEntity;
	}
}
