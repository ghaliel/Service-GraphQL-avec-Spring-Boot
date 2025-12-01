package com.exemple.banqueservice;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.exemple.banqueservice.entities.Compte;
import com.exemple.banqueservice.entities.Transaction;
import com.exemple.banqueservice.entities.TypeCompte;
import com.exemple.banqueservice.entities.TypeTransaction;
import com.exemple.banqueservice.repositories.CompteRepository;
import com.exemple.banqueservice.repositories.TransactionRepository;

@SpringBootApplication
public class GraphApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, TransactionRepository transactionRepository) {
        return args -> {
            // Créer des comptes
            Compte c1 = new Compte(null, 8271.79, new Date(), TypeCompte.EPARGNE);
            Compte c2 = new Compte(null, 3672.76, new Date(), TypeCompte.COURANT);
            Compte c3 = new Compte(null, 422.17, new Date(), TypeCompte.EPARGNE);
            
            compteRepository.save(c1);
            compteRepository.save(c2);
            compteRepository.save(c3);
            
            // Créer des transactions
            Transaction t1 = new Transaction(null, 500.0, new Date(), TypeTransaction.DEPOT, c1);
            Transaction t2 = new Transaction(null, 200.0, new Date(), TypeTransaction.RETRAIT, c1);
            Transaction t3 = new Transaction(null, 1000.0, new Date(), TypeTransaction.DEPOT, c2);
            Transaction t4 = new Transaction(null, 300.0, new Date(), TypeTransaction.RETRAIT, c2);
            Transaction t5 = new Transaction(null, 150.0, new Date(), TypeTransaction.DEPOT, c3);
            
            transactionRepository.save(t1);
            transactionRepository.save(t2);
            transactionRepository.save(t3);
            transactionRepository.save(t4);
            transactionRepository.save(t5);
            
            System.out.println("=== Données initiales créées ===");
        };
    }

}
