package com.vineethds.hash;

class HashTableDemo {
    public static void main(String[] args)
    {
        HashTable table = new HashTable(); //Create a HashTable
        //Before Insertion
        System.out.println("Table Size = " + table.size());
        table.insert("This",1 ); //Key-Value Pair
        table.insert("is",2 );
        table.insert("a",3 );
        table.insert("Test",4 );
        table.insert("Driver",5 );
        System.out.println("Table Size = " + table.size());
        // first search the key then delete it in the table
        // see the implementation first
        System.out.println(table.delete("is")+ " : This key is deleted from table");
        System.out.println("Now Size of the table = " + table.size() );
        if(table.isEmpty())
            System.out.println("Table is Empty");
        else
            System.out.println("Table is not Empty");

    }
}
