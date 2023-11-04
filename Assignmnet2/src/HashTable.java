


public class HashTable {
    int[] table;
    static final int MODULUS_VALUE = 13;
    int size = 0;
    double threshold = 0.7;
    HashTable(int capacity){
        table = new int[capacity];
    }
    private int Hash(int value){
        return value%MODULUS_VALUE;
    }
    public void insert(int value){
        if((double)size/table.length > threshold){
            resize(2*table.length);
        }
        int index = Hash(value);
        while(table[index] != 0){
            index = (index + 1) %table.length;
        }
        table[index] = value;
        size++;
    }
    public void display(){
        System.out.println("Hashtable: ");
        for(int i = 0; i<table.length; i++){
            System.out.println("slot" + i + ":" + table[i]);
        }
    }
    private void resize(int newCapacity){
        int[] newTable = new int[newCapacity];
        for(int value: table){
            if(value != 0){
                int index = value% newCapacity;
                while(newTable [index] != 0){
                    index = (index + 1) %newCapacity;
                }
                newTable[index] =  value;
            }
        }
        table = newTable;
    }
}
