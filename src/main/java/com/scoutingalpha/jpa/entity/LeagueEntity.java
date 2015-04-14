package com.scoutingalpha.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "league")
public class LeagueEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer leagueEntityId;

	@Column(name = "name", length = 45)
	private String leagueEntityName;

	// @OneToMany(mappedBy = "leagueIdleague")
	// private Set<Team> teams;

	protected LeagueEntity() {
		super();
	}

	public LeagueEntity(String name) {
		super();
		this.leagueEntityName = name;
	}

	public Integer getLeagueEntityId() {
		return leagueEntityId;
	}

	public void setLeagueEntityId(Integer id) {
		this.leagueEntityId = id;
	}

	public String getLeagueEntityName() {
		return leagueEntityName;
	}

	public void setLeagueEntityName(String name) {
		this.leagueEntityName = name;
	}

	@Override
	public String toString() {
		return "LeagueEntity [leagueEntityId=" + leagueEntityId
				+ ", leagueEntityName=" + leagueEntityName + "]";
	}

}
