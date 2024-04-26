package com.greenrent.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name="tbl_cmessage")
public class ContactMessage implements Serializable {  /**   //bu entiyiy networkda dolastirmak istersek eger bu  Serializable ozamn kullanilir

*
*/
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1,max=50,message="Your Name '{validatedValue}' must be between  {min} and {max} chars long")
	@NotNull(message= "Please provide your name")
	@Column(length = 50, nullable = false)
	private String name;
	
	
	@Size(min=5,max=50,message="Your subject '{validatedValue}' must be between  {min} and {max} chars long")
	@NotNull(message= "Please provide message subject")
	@Column(length = 50, nullable = false)
	private String subject;
	
	
	@Size(min=20,max=200,message="Your message body '{validatedValue}' must be between  {min} and {max} chars long")
	@NotNull(message= "Please provide message body")
	@Column(length = 50, nullable = false)
	private String body;
	
	@Email
	@Column(length = 50, nullable = false)
	private String email;
	
	
	
	
	
	
	
	
	
	
	
	
	

}
