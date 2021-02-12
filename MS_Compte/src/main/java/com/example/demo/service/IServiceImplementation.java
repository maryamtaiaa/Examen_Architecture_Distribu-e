package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;
import com.example.demo.repository.CompteRepository;
import com.example.demo.repository.OperationRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class IServiceImplementation implements IService{

	private CompteRepository compteRepository;
	private OperationRepository operationRepository;
	private ClientService clientService;

	public IServiceImplementation(CompteRepository compteRepository, OperationRepository operationRepository, ClientService clientService) {
		this.compteRepository = compteRepository;
		this.operationRepository = operationRepository;
		this.clientService = clientService;
	}

	@Override
	public Compte addCompte(Compte c) {
		Compte compte=compteRepository.save(c);
		return compte;
	}

	@Override
	public void versement(double montant, Long code) {
		Compte c=compteRepository.findById(code).get();
		Operation o=new Operation();
		o.setCompte(c);
		o.setDateOperation(new Date());
		o.setType("CREDIT");
		c.setSolde(c.getSolde()+montant);
		compteRepository.save(c);
		operationRepository.save(o);
	}

	@Override
	public void retrait(double montant, Long code) {
		Compte c=compteRepository.findById(code).get();
		Operation o=new Operation();
		o.setCompte(c);
		o.setDateOperation(new Date());
		o.setType("DEBIT");
		c.setSolde(c.getSolde()-montant);
		compteRepository.save(c);
		operationRepository.save(o);

	}

	@Override
	public void virement(double montant, Long codeS, Long codeD) {
		retrait(montant,codeS);
		retrait(montant,codeD);
		
	}

	@Override
	public List<Operation> consulter(Long code, int page, int size) {
		Page<Operation> operations=operationRepository.findByCompte_Code(code, PageRequest.of(page, size));
		return operations.getContent();
	}

	@Override
	public Compte consulterCompte(Long code) {
		Compte c=compteRepository.findById(code).get();
		c.setClient(clientService.findClientById(c.getClientID()));
		return c;
	}

	@Override
	public void changeEtat(Long code, String etat) {
		Compte c=compteRepository.findById(code).get();
		c.setEtat(etat);
		compteRepository.save(c);
	}
	

}
