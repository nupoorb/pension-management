package com.pensionmanagement.pensiondisbursement.model;


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
public class PensionerDetail {
  private long aadharNumber;
  private String name;
  private Date dateOfBirth;
  private String pan;
  private double salaryEarned ;
  private double  allowances ;
  private String pensionType;
  private String bankName;
  private long accountNumber;
  private String bankType;
  
 
}
