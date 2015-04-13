package com.scoutingalpha.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.scoutingalpha.jpa.entity.LeagueEntity;

@Repository
public interface LeagueRepository extends
		PagingAndSortingRepository<LeagueEntity, Integer> {

}
