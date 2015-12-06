/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziskani_kurzu_men_online;

/**
 *
 * @author Matěj
 */
public class Person  {
  static String name;
  static double age;
  static double height;
  static double weight;

  Person(String name, double age, double height, double weight) {
    Person.name = name;
    Person.age = age;
    Person.height = height;
    Person.weight = weight;
  }
}

public static void main(String[] args) {
  Person joe = new Person("Joe", 30, 70, 180);
  ArrayList<Person> people = new ArrayList<Person>();
  people.add(joe);
}