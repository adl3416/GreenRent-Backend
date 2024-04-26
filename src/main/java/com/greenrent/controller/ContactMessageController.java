package com.greenrent.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenrent.domain.ContactMessage;
import com.greenrent.service.ContactMessageService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController                      // bu class controlldur dedik
@RequestMapping("/contactmessage")  // mesaj ekleme cikarma icin
@AllArgsConstructor
public class ContactMessageController {
		
	    @Autowired
		private ContactMessageService contactMessageService;   // service  bagliyoruz
		
		@PostMapping("/visitor")                                    // kisiyiyada mesaji kayitetmek icin @PostMapping kullanilir
		public ResponseEntity<Map<String,String>> createMessage(@Valid @RequestBody ContactMessage  contactMessage){ //giden request, gelencevap responseentitydir.createMessage olusturuyorum ve bu mesaj valid yani bizim sartlarimiza uygun olcak.@RequestBody bütün mesjlari cevaplari getircek
		
			Map<String,String> map =new HashMap<>();
			map.put("message", "Contact Message Succesfully Created");
			map.put("status", "true");
			return new ResponseEntity<>(map,HttpStatus.OK);
			
		}
		
		@GetMapping  //getirmemizi sagliyor.
		public ResponseEntity<List<ContactMessage>> getAllContactMessage(){
			contactMessageService.getAllContactMessage(); // yukarida messageService(MessageService den) olusturduk. Ona e git  orda ben sana bir tane method yazcagim onu cagir gel.MessageService gidiyoruz orda getAllMessage olmadigi icin olusturmaliyiz
			
			List<Message> allMessage=	messageService.getAllMessage(); //repositoryden gelen responseentiy. Bana list döndü  buna ismm verdim allMessage
//			return new ResponseEntity<>(allMessage,HttpStatus.OK);  2. yontem
			return  ResponseEntity.ok(allMessage); // staticse . ok ile cagirabiliyoruz
		}
		
		  @DeleteMapping("/{id}")
		  public ResponseEntity<Map<String,String>> deleteContactMessage(@PathVariable Long id){ //id yi alabilmek icin @PathVariable  kullaniyoruz
		  contactMessageService.deleteContactMessage(id);  //messagecomtactService git ve deleteContatMessage(id) yaz.Hangi meseji silceginide veriyoruz (id)-->ContactMesssageService clasina gönderdim silmek icin. MesssageService eye gidiyoruz.
		  
		  }
		
		
}
