package com.lj.cascade.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lj_userLj")
public class UserLj {
	private int id;
	private String name;
	private Set<CardLj> cards = new HashSet<CardLj>();
	
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
	
	@OneToMany(mappedBy="userlj", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<CardLj> getCards() {
		return cards;
	}
	public void setCards(Set<CardLj> cards) {
		this.cards = cards;
	}
	
}
