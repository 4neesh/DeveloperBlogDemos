package com.aneesh.main;

import com.aneesh.dataStructure.ChainedHash;

public class Application {

    public static int numberOfCollisions = 0;

    public static void main(String[] args) {

        ChainedHash hashTable = new ChainedHash(8);

        System.out.println("First entry (Alex, 47)..");
        hashTable.put("Alex", 47);
        hashTable.printEntryLinkedList();

        System.out.println("\nOne more entry (George, 80)..");
        hashTable.put("George", 80);
        hashTable.printEntryLinkedList();

        System.out.println("\nOne more entry (Phillip, 19)..");
        hashTable.put("Phillip", 19);
        hashTable.printEntryLinkedList();

        System.out.println("\nOne more entry (Eliza, 97)..");
        hashTable.put("Eliza", 97);
        hashTable.printEntryLinkedList();

        System.out.println("\nOne more entry (John, 90)..");
        hashTable.put("John", 90);
        hashTable.printEntryLinkedList();

        System.out.println("\nOne more entry (Lin, 16)..");
        hashTable.put("Lin", 16);
        hashTable.printEntryLinkedList();

        System.out.println("\nOne more entry (Miranda, 84)..");
        hashTable.put("Miranda", 84);
        hashTable.printEntryLinkedList();


        System.out.println("\nTotal collisions: " + numberOfCollisions);
    }

    }


