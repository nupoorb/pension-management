package com.pensionmanagement.processpension.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PensionDetail {

	@Id
	private long aadharNumber;
	private String name;
	private Date dateOfBirth;
	private String pan;
	private String pensionType;
	private double pensionAmount;
	
	
}
