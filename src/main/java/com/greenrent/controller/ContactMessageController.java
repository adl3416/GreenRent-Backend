package com.greenrent.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenrent.domain.ContactMessage;
import com.greenrent.service.ContactMessageService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController                      // bu class controlldur dedik
@RequestMapping("/contactmessage")  // mesaj ekleme cikarma icin  path veriyoruz
@AllArgsConstructor                    //  2.yontem ContactMessageService  buradn ulasmak icin 
public class ContactMessageController {
		
	    @Autowired // ContactMessageService  buradn ulasmak icin 
		private ContactMessageService contactMessageService;   // service  bagliyoruz. controlldeyken serviceyi cagiriyoruz
		 
	    
	    //localhost:8080/contactmessage/visitor
		@PostMapping("/visitor")                                                                                        // kisiyiyada mesaji kayitetmek icin @PostMapping kullanilir
		public ResponseEntity<Map<String,String>> createMessage(@Valid @RequestBody ContactMessage  contactMessage){ //giden request, gelencevap responseentitydir.createMessage olusturuyorum ve bu mesaj valid yani bizim sartlarimiza uygun olcak.@RequestBody bütün mesjlari cevaplari getircek
		//bana ResponseEntity olarak geri dönsün.                             //ContactMessage  domainden aliyoruz
			
			contactMessageService.createContactMessage(contactMessage);  //service git burda bitane createContactMessage servise methodu olustur. icindede contactMessagei gönderiyorum kayit icin.
			  
			
			Map<String,String> map =new HashMap<>();
			map.put("message", "Contact Message Succesfully Created");
			map.put("status", "true"); 
			return new ResponseEntity<>(map,HttpStatus.OK);
			
		}
		
		@GetMapping //getirmemizi sagliyor.
		public ResponseEntity<List<ContactMessage>> getAllContactMessage(){
			
			//contactMessageService.getAllContactMessage();  // yukarida messageService(MessageService den) olusturduk. Ona e git  orda ben sana bir tane method yazcagim onu cagir gel.MessageService gidiyoruz orda getAllMessage olmadigi icin olusturmaliyiz
			
			
			List<ContactMessage> list =contactMessageService.getAll(); //repositoryden gelen responseentiy. Bana list döndü  
//			
			return  ResponseEntity.ok(list); // staticse . ok ile cagirabiliyoruz
		}
		
		
		//localhost:8080/contactmessage/1
		@GetMapping("/{id}")  //id ile cagiriyoruz. //ResponseEntity olarak bir tane mesj gelecek.
		public ResponseEntity<ContactMessage> getMessage(@PathVariable("id") Long id){ // @PathVariable Long id ile id i almis olduk
		ContactMessage contMessage=	contactMessageService.getContactMessage(id);   // messageService  ne git getMessage olustur ve icesine id gönder. onagöre bana msj gelcek. simdi MessageService ye gidelim. olusturalim 
		  // burada bir mesaj döndü bunuda contMessage ye atadik
		return  ResponseEntity.ok(contMessage);   // buradanda contactMessage yi cagiriyoruz
		}
		
		
		@GetMapping("/request")  // @RequestParam  ve  @PathVariable birbiri ile ayni isi yapiyor  sadece yazilislari farkli
		public ResponseEntity<ContactMessage> getMessageWithRequestParam(@RequestParam ("id") Long id) {
			ContactMessage contactMessage=	contactMessageService.getContactMessage(id);
			return  ResponseEntity.ok(contactMessage);
		 }
		
		
		
		@PutMapping("/{id}")
		
		public ResponseEntity<Map<String,String>> updateContactMessage(@PathVariable("id") Long id,@Valid @RequestBody ContactMessage contactMessage ){ //("id") yazilmali
			contactMessageService.updateContactMessage(id,contactMessage);
			
			//Kullaniciya mesaj vermek icin map kullaniyorum.Mesela basarilibirsekilde kayit oldun. "succes"vb.
			 
			Map<String,String> map=new HashMap<>();
			 map.put("message", "Contact Message Succesfully Updated"); 
			 map.put("status", "true"); 
			 return new ResponseEntity<>(map,HttpStatus.OK);  // burayada map i gönderiyorum. Dönüs olarak da map istiyo onuda  public ResponseEntity<Map<String,String>>... olarak yaziyorum.
		 }
		
		
		
		
	
		
		  @DeleteMapping("/{id}")
		  public ResponseEntity<Map<String,String>> deleteContactMessage(@PathVariable("id") Long id){ //id yi alabilmek icin @PathVariable  kullaniyoruz
		  contactMessageService.deleteMessage(id);  //messagecomtactService git ve deleteContatMessage(id) yaz.Hangi meseji silceginide veriyoruz (id)-->ContactMesssageService clasina gönderdim silmek icin. MesssageService eye gidiyoruz.
		  
		  Map<String,String> map=new HashMap<>();
			 map.put("message", "Contact Message Succesfully Deleted"); 
			 map.put("status", "true"); 
			 return new ResponseEntity<>(map,HttpStatus.OK); 
		  }
		  
		/*
		 @DeleteMapping("/{id}")
		  public ResponseEntity<Map<String,String>> deleteMessage(@PathVariable("id") Long id){ //id yi alabilmek icin @PathVariable  kullaniyoruz
			 contactMessageService.deleteMessage(id);  //messageService git ve deleteMessage(id) yaz.Hangi meseji silceginide veriyoruz (id)-->MesssageService clasina gönderdim silmek icin. MesssageService eye gidiyoruz.
				
				 
				 //Kullaniciya mesaj vermek icin map kullaniyorum.Mesela basarilibirsekilde kayit oldun. "succes"vb.
				 Map<String,String> map=new HashMap<>();
				 map.put("succes", String.valueOf(true)); //dogru ise true yani silinince true yazacak
				 map.put("id", String.valueOf(id.longValue())); // long u stringe ceviriyoruz
				 return new ResponseEntity<>(map,HttpStatus.OK);  // burayada map i gönderiyorum. Dönüs olarak da map istiyo onuda 71. satira  public ResponseEntity<Map<String,String>>... olarak yaziyorum.
			 }
		

		*/



}
