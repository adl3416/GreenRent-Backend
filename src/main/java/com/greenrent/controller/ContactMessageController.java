package com.greenrent.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController // bu class controlldur dedik
@RequestMapping("/contactmessage")  // mesaj ekleme cikarma icin
public class ContactMessageController {
	
		@PostMapping("/visitor") //
		public ResponseEntity<Map<String,String>> createMessage(@Valid @RequestBody ContactMessage  contactMessage){
		
		}
}
