package com.greenrent.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		
		private ContactMessageService contactMessageService;   // service  bagliyoruz
		
		@PostMapping("/visitor")                                    // kisiyiyada mesaji kayitetmek icin @PostMapping kullanilir
		public ResponseEntity<Map<String,String>> createMessage(@Valid @RequestBody ContactMessage  contactMessage){ //giden request, gelencevap responseentitydir.createMessage olusturuyorum ve bu mesaj valid yani bizim sartlarimiza uygun olcak.@RequestBody bütün mesjlari cevaplari getircek
		
			Map<String,String> map =new HashMap<>();
			map.put("message", "Contact Message Succesfully Created");
			map.put("status", "true");
			return new ResponseEntity<>(map,HttpStatus.OK);
			
		}
		
		
}
