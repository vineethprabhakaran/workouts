package com.vineethds.hash;

import java.util.ArrayList;

public class HashTable {
    private ArrayList<HashEntry> bucket;
    private int slots;
    private int size;

    public HashTable(){
        bucket = new ArrayList<>();
        slots = 10;
        size = 0;
        for(int i = 0; i< slots ;i++){
            bucket.add(null);
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public int getIndex(String key){
        int hash = key.hashCode();
        int index = hash % slots;
        if(index < 0){
            index = (index + slots) % slots;
        }
        return index;
    }

    public void insert(String key, int value){
        int index = getIndex(key);
        HashEntry head = bucket.get(index);
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        HashEntry newNode = new HashEntry(key,value);
        head = bucket.get(index);
        newNode.next = head;
        bucket.set(index,newNode);
        // If 60% of the array gets filled, double the size
        if((1.0 * size)/slots >= 0.6){
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList<>();
            slots = 2 * slots;
            size++;
            for(HashEntry he : temp){
                while(he != null){
                    insert(he.key,he.value);
                    he = he.next;
                }

            }
        }
    }

    public int get(String key){
        int index = getIndex(key);
        HashEntry head = bucket.get(index);
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return -1;
    }

    public int delete(String key){
        int index = getIndex(key);
        HashEntry head = bucket.get(index);
        HashEntry prev = null;
        while (head != null){

            if(head.key.equals(key))
                break;

            prev = head;
            head = head.next;
        }

        if(head == null){
            return -1;
        }
        size--;
        if(prev != null){
            prev.next = head.next;
        }else{
            bucket.set(index, head.next);
        }
        return head.value;
    }

}
