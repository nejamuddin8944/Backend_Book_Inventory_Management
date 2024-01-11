package com.bim.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "SHOPPINGCART")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
	@EmbeddedId
    private ShoppingCartId id;
	
	@ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "userId", insertable = false, updatable = false)
    private User user;
 
    @ManyToOne
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN", insertable = false, updatable = false)
    private Book book;
 

}
