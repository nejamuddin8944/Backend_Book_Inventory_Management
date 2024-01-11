package com.bim.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PURCHASELOG")
public class PurchaseLog {

	@EmbeddedId
	private PurchaseLogId id;
	
	@ManyToOne
	@JoinColumn(name = "USERID" , referencedColumnName = "userID" , insertable = false , updatable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "INVENTORYID" ,referencedColumnName = "inventoryID" , insertable = false , updatable = false)
	private Inventory inventory;
	
	
}
