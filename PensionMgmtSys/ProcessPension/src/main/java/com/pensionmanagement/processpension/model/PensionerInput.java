package com.pensionmanagement.processpension.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PensionerInput {

	private String name;
	private Date dateOfBirth;
	private String pan;
	private long aadharNumber;
	private String pensionType;
	
	
}