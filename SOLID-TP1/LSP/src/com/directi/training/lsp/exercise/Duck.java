package com.directi.training.lsp.exercise;
public class Duck implements IDuck
{
    @Override
    public void quack()
    {
        System.out.println("Quack.....");
    }

    @Override
    public void swim()
    {
        System.out.println("Swim....");
    }

}