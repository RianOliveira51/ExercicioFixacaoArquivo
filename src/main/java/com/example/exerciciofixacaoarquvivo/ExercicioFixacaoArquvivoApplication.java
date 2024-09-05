package com.example.exerciciofixacaoarquvivo;

import com.example.exerciciofixacaoarquvivo.entities.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ExercicioFixacaoArquvivoApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos produtos serão digitados: ");
        int n = sc.nextInt();

        Produto[] produtos = new Produto[n];

        for(int i=0; i<n; i++){
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity:");
            int quantity = sc.nextInt();

            produtos[i] = new Produto(name,price,quantity);
            produtos[i].total();
        }

        System.out.println("Imprimindo produtos: ");

        for(int i =0; i<n; i++){
            System.out.println(produtos[i]);
        }



    }

}
