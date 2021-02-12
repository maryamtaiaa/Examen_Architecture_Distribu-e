package com.example.demo.controller;

import com.example.demo.dto.Retrait;
import com.example.demo.dto.Virement;
import com.example.demo.entities.Operation;
import com.example.demo.service.IService;
import com.example.demo.service.IServiceImplementation;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Compte;

import java.util.List;


@RestController
public class CompteController {
	private IService service;

	public CompteController(IService service) {
		this.service=service;
	}

	@GetMapping("/comptes/{id}")
	public Compte getCompte(@PathVariable(name="id") Long id) {
		return service.consulterCompte(id);
	}
	@PostMapping("/comptes")
	public Compte saveCompte(@RequestBody Compte c){
		return service.addCompte(c);
	}
	@PostMapping("/comptes/etat/{id}")
	public void changeEtat(@PathVariable(name = "id") Long id,@RequestBody String etat){
		service.changeEtat(id,etat);
	}
	@PostMapping("/comtes/retrait")
	public void retrait(@RequestBody Retrait retrait){
		service.retrait(retrait.getMontant(),retrait.getCode());
	}
	@PostMapping("/comtes/versement")
	public void versement(@RequestBody Retrait retrait){
		service.retrait(retrait.getMontant(),retrait.getCode());
	}
	@PostMapping("/comtes/virement")
	public void versement(@RequestBody Virement virement){
		service.virement(virement.getM(),virement.getCodeS(),virement.getCodeD());
	}
	@GetMapping("/comptes/operations/{id}")
	public List<Operation> getOperations(@PathVariable(name = "id") Long id,@RequestParam(name = "page", defaultValue = "0") int p,
										 @RequestParam(name = "size", defaultValue = "4") int s){
		return service.consulter(id,p,s);
	}
}
