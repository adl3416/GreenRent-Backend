package com.greenrent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenrent.domain.ContactMessage;
import com.greenrent.exception.ResourceNotFoundException;
import com.greenrent.exception.message.ErrorMessage;
import com.greenrent.repository.ContactMessageRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ContactMessageService {
	
	@Autowired   // burdan ulasabilmemizi sagliyor
	private ContactMessageRepository repository;   //service de repositorye baglaniyor
	
	
	
	       //buraya void de yazabiliriz ozaman bisey döndürmez simdi ContactMessage döndurcek
	public ContactMessage createContactMessage(ContactMessage contactMessage) { // controllerden gönderilen messageyi aliyoruz controllerin istegi ile createContactMessage olusturuyorum.                                  
		ContactMessage msg = repository.save(contactMessage);  // messageyi Repository e gönderip veri tabanina kayit ediyoruz
		return msg;  //ve return olarak bana bu messageyi(msg) geri gönder
	}
	
	
	
	
	public List<ContactMessage> getAllContactMessage(){  // ContactMessageController classindan buraya geldik getAllMessage yi olusturduk. Repositoory göndercez
		return repository.findAll();                     //repositoryy git ve findAll ile hepsi getir.List döndürcek
	}
	
	
	public  ContactMessage getContactMessage(Long id) { //messageRepository git findById(id) getir. Bulunan mesaji return foundMessage; ile geri gönder
	    return  repository.findById(id).orElseThrow(()->
	     new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE,id)));
	}
	
	
	
	
	
	public void deleteContactMessage(Long id) throws ResourceNotFoundException{  //eger o id yi bulamassa exception firlat
	 ContactMessage message= getContactMessage(id); //buda messageRepository baglancak deleteById(id) ile silcek
		//geri bisey göndermicek.
	}

}
