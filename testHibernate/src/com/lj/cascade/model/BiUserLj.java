package com.lj.cascade.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lj_biuserLj")
public class BiUserLj {
	private int id;
	private String name;
	private Set<BiCardLj> cards = new HashSet<BiCardLj>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="usersId")
	public Set<BiCardLj> getCards() {
		return cards;
	}
	public void setCards(Set<BiCardLj> cards) {
		this.cards = cards;
	}
	
}
