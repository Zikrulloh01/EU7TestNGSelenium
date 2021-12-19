package com.cybertek.tests;
import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
public class FirstClass {

    public static void main(String[] args) {

        System.out.println("\nAssalamu alaikum. Bismillah");
        Faker faker = new Faker();

        System.out.println("Full name : " + faker.name().fullName());

        System.out.println("Character: " + faker.harryPotter().character());

        System.out.println("American Express: " + faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS));

    }

}
