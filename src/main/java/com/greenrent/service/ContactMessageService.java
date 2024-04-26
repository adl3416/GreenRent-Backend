package com.greenrent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenrent.domain.ContactMessage;
import com.greenrent.repository.ContactMessageRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ContactMessageService {
	
	@Autowired   // burdan ulasabilmemizi sagliyor
	private ContactMessageRepository repository;   //service de repositorye baglaniyor
	
	public void createMessage(ContactMessage contactMessage) { // controllerden gönderilen messageyi aliyoruz
		                                      
		ContactMessage msg = repository.save(contactMessage);  // messageyi Repository e gönderip veri tabanina kayit ediyoruz
		return ;  // ve return olarak bana bu messageyi(msg) geri gönder
	}

}
