package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;

public interface IService {

	Compte addCompte(Compte c);
	void versement(double montant,Long code);
	void retrait(double montant,Long code);
	void virement(double montant,Long codeS,Long codeD);
	List<Operation> consulter(Long code,int page,int size);
	Compte consulterCompte(Long code);
	void changeEtat(Long code,String etat);
	
}
