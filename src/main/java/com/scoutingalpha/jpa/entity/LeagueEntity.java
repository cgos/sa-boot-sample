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
	private Integer id;

	// @OneToMany(mappedBy = "leagueIdleague")
	// private Set<Team> teams;

	protected LeagueEntity() {
		super();
	}

	public LeagueEntity(String name) {
		super();
		this.name = name;
	}

	@Column(name = "name", length = 45)
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LeagueEntity [id=" + id + ", name=" + name + "]";
	}

}
