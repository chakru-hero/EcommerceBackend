package com.portfolio.chakru.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Collection;

@Entity
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartModel {

	@Id
	@Column	(nullable = false , updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany
	private Collection<CartEntryModel> cartEntry;
	@OneToOne(targetEntity=UserModel.class, fetch=FetchType.EAGER)
	private UserModel user;
}
