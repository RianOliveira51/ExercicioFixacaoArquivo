package com.example.exerciciofixacaoarquvivo;

import com.example.exerciciofixacaoarquvivo.entities.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
/*Fazer um programa para ler o caminho de um arquivo .cvs, contendo os dados de itens vendidos. Cada item
* possui um nome, preço, unitário e quantidade, separados por vírgulas. Você deve gerar um novo arquivo
* chamado "summary.cvs*, localizado em uma subpasta "out" a partir da pasta original do arquivo de origem
 contendo apenas o nome e o valor total para aquele item.
 */
@SpringBootApplication
public class ExercicioFixacaoArquvivoApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Produto> list = new ArrayList<>();

        System.out.println("Enter file path: ");
        String sourceFileStr = "C:\\Users\\rian-oliveira\\Contacts\\Desktop\\Pessoal\\Linguagens\\Java\\Curso Java Orientado a Objeto - udemy\\Exercicio Arquivo\\Arquivo.csv";

        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        boolean success = new File(sourceFolderStr + "\\out").mkdir();

        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

            String itemCsv = br.readLine();
            while (itemCsv != null) {

                String[] fields = itemCsv.split(";");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                list.add(new Produto(name, price, quantity));

                itemCsv = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

                for (Produto item : list) {
                    bw.write(item.getName() + "," + String.format("%.2f", item.total()));
                    bw.newLine();
                }

                System.out.println(targetFileStr + " CREATED!");

            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Teste");
        sc.close();


    }

}
