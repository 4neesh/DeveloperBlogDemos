package com.aneesh.dataStructure;

import com.aneesh.main.Application;

public class ChainedHash {

    private double loadFactor;
    EntryLinkedList[] hashTableBuckets;
    private static int numberOfBuckets;
    private double numberOfEntries = 0;
    public static final double MAX_LOAD_FACTOR = 0.75;

    public ChainedHash(int bucketsToCreate){
        numberOfBuckets = bucketsToCreate;
        hashTableBuckets = new EntryLinkedList[numberOfBuckets];
        for (int i = 0; i < numberOfBuckets; i++) {
            hashTableBuckets[i] = null;
        }
    }

    public void put(String key, int value) {
        int hashValue = hashFunction(key);
        numberOfEntries++;
        validateLoadFactor();

        //check if the bucket for the hash value is null
        if (hashTableBuckets[hashValue] == null) {

            hashTableBuckets[hashValue] = new EntryLinkedList(key, value);

        } else {
            //the bucket already has a LinkedList and will either append an entry or create re-insert the first value
            EntryLinkedList hashValueLinkedList = hashTableBuckets[hashValue];

            //find either the next position available in the ValueLinkedList or the current position populated by the key
            while (hashValueLinkedList.getNextListEntry() != null && !hashValueLinkedList.getKey().equals(key)) {
                hashValueLinkedList = hashValueLinkedList.getNextListEntry();
            }

            //if the position in ValueLinkedList is already occupied by the key, reassign the value
            if (hashValueLinkedList.getKey().equals(key)) {
                hashValueLinkedList.setValue(value);
            } else {
                //otherwise create a new entry to the ValueLinkedList
                Application.numberOfCollisions++;
                hashValueLinkedList.setNextListEntry(new EntryLinkedList(key, value));
            }

        }

    }

    private void validateLoadFactor() {
        if(calculateLoadFactor() > MAX_LOAD_FACTOR){
            numberOfBuckets = numberOfBuckets * 2;
            System.out.println("Load factor is too high: " + loadFactor);
            System.out.println("Buckets raised to: " + numberOfBuckets + " buckets.");
            this.rehash();
        }

    }

    public void printEntryLinkedList() {
        for (EntryLinkedList i : hashTableBuckets) {
            if (i != null)
                System.out.println(i);
        }
    }

    private void rehash(){

        EntryLinkedList[] temp = hashTableBuckets;

        hashTableBuckets = new EntryLinkedList[numberOfBuckets];
        numberOfEntries = 0;
        for(int i = 0; i< temp.length; i++){
            if(temp[i] != null){
                this.put(temp[i].getKey(), temp[i].getValue());

                while(temp[i].getNextListEntry()!= null){
                    this.put(temp[i].getNextListEntry().getKey(), temp[i].getNextListEntry().getValue());
                    temp[i] = temp[i].getNextListEntry();
                }
            }
        }
    }

    private double calculateLoadFactor(){

        loadFactor =  numberOfEntries / numberOfBuckets;
        return loadFactor;
    }

    private static int hashFunction(String key) {

        int asciiValue = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            asciiValue = asciiValue + (int) c;
        }

        int hashValue = Math.round(asciiValue % numberOfBuckets);

        return hashValue;
    }


    class EntryLinkedList{

        private String key;
        private int value;
        private EntryLinkedList nextListEntry;

        EntryLinkedList(String key, int value) {
            this.key = key;
            this.value = value;
            this.nextListEntry = null;
        }
        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public EntryLinkedList getNextListEntry() {
            return nextListEntry;
        }

        public void setNextListEntry(EntryLinkedList nextListEntry) {
            this.nextListEntry = nextListEntry;
        }

        @Override
        public String toString() {
            return
                    "[hash value='"  + ChainedHash.hashFunction(key) +'\'' +
                            ", key='" + key + '\'' +
                            ", value=" + value +
                            "], " + nextListEntry;
        }
    }

}
