package com.pensionmanagement.processpension.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class PensionerDetailPojo {

	private long aadharNumber;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private String pan;
	private double salaryEarned;
	private double allowances;
	private String pensionType;
	private String bankName;
	private long accountNumber;
	private String bankType;
	
}
