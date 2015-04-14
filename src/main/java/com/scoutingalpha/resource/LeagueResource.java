package com.scoutingalpha.resource;

import org.springframework.hateoas.ResourceSupport;

import com.scoutingalpha.jpa.entity.LeagueEntity;

public class LeagueResource extends ResourceSupport {
	private Integer leagueId;
	private String leagueName;


	public LeagueResource(LeagueEntity leagueEntity) {
		leagueId = leagueEntity.getLeagueEntityId();
		leagueName = leagueEntity.getLeagueEntityName();
	}

	public Integer getLeagueId() {
		return leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}
}
