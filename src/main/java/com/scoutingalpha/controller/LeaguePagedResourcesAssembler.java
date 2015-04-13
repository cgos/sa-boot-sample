package com.scoutingalpha.controller;

import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Component;

import com.scoutingalpha.jpa.entity.LeagueEntity;

@Component
public class LeaguePagedResourcesAssembler extends PagedResourcesAssembler<LeagueEntity> {

	public LeaguePagedResourcesAssembler() {
		super(null, null);
	}
}
