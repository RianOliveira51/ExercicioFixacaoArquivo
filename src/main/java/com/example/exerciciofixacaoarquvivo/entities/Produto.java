package com.example.exerciciofixacaoarquvivo.entities;

public class Produto {
    private String name;
    private double price;
    private int quant;

    public Produto(){

    }

    public Produto(String name, double price, int quant){
        this.name = name;
        this.price = price;
        this.quant = quant;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public int getQuant(){
        return quant;
    }

    public void setQuant(){
        this.quant = quant;
    }

    public double total(){
        return price * quant;
    }

    public String toString(){
        return name + "," + String.format("%.2f", price) + quant + "," + String.format("%.2f", total());
    }
}
