package com.jpmc.midascore.foundation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jpmc.midascore.entity.UserRecord;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "transactions")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @ManyToOne
	    @JoinColumn(name = "sender_id") // Maps to user_record.id
	    private UserRecord sender;

	    @ManyToOne
	    @JoinColumn(name = "recipient_id") // Maps to user_record.id
	    private UserRecord recipient;

	
	    private float amount;

	    private float incentive;

	    public float getIncentive() { return incentive; }
	    public void setIncentive(float incentive) { this.incentive = incentive; }
	    // Default constructor (required by JPA)
	    public Transaction() {}

	    // Existing constructor
	  
    public Transaction(long long1, long long2, float float1) {
			// TODO Auto-generated constructor stub
		}
	
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserRecord getSender() {
		return sender;
	}
	public void setSender(UserRecord sender) {
		this.sender = sender;
	}
	public UserRecord getRecipient() {
		return recipient;
	}
	public void setRecipient(UserRecord recipient) {
		this.recipient = recipient;
	}
	public Transaction(Long id, UserRecord sender, UserRecord recipient, float amount, float incentive) {
		super();
		this.id = id;
		this.sender = sender;
		this.recipient = recipient;
		this.amount = amount;
		this.incentive = incentive;
	}

   
}
