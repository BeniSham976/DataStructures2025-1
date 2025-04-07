package utils;

import java.util.ArrayList;
import java.util.List;

public class ContactHashMap {
    private static final int INITIAL_SIZE = 103;
    private ArrayList<Entry>[] map;
    private int count;

    public ContactHashMap(){
        map = new ArrayList[INITIAL_SIZE];
        count = 0;
    }

    public Integer put(String key, Integer value){
        validateKey(key);

        // Call dedicated method to calculate the appropriate destination for the value
        // This adheres to single responsibility principle
        int destinationSlot = calculateSlot(key);

        // If the slot is available
        if(map[destinationSlot] == null){
            // No value is present, create list to start using slot
            map[destinationSlot] = new ArrayList<Entry>();
        }

        ArrayList<Entry> slotList = map[destinationSlot];
        for (int i = 0; i < slotList.size(); i++) {
            Entry currentEntry = slotList.get(i);
            if(currentEntry.key.equals(key)){
                Integer oldValue = currentEntry.value;
                currentEntry.value = value;
                return oldValue;
            }
        }

        Entry newEntry = new Entry(key, value);
        slotList.add(newEntry);
        count++;

        return null;
    }

    public Integer get(String key){
        validateKey(key);

        // Call dedicated method to calculate the appropriate destination for the value
        // This adheres to single responsibility principle
        int destinationSlot = calculateSlot(key);

        if(map[destinationSlot] == null || map[destinationSlot].isEmpty()){
            return null;
        }

        ArrayList<Entry> slotList = map[destinationSlot];
        for (int i = 0; i < slotList.size(); i++) {
            Entry currentEntry = slotList.get(i);
            if(currentEntry.key.equals(key)){
                return currentEntry.value;
            }
        }
        return null;
    }

    public boolean containsKey(String key){
        validateKey(key);

        Integer value = get(key);
        if(value != null){
            return true;
        }
        return false;
    }

    public Integer remove(String key){
        validateKey(key);

        int destinationSlot = calculateSlot(key);

        List<Entry> slotList = map[destinationSlot];
        if(slotList == null){
            return null;
        }

        for (int i = 0; i < slotList.size(); i++) {
            Entry currentEntry = slotList.get(i);
            if(currentEntry.key.equals(key)){
                Integer oldValue = currentEntry.value;
                slotList.remove(i);
                count--;
                return oldValue;
            }
        }

        return null;
    }


    private static void validateKey(String key) {
        if(key == null){
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    private int calculateSlot(String key) {
        // Convert key's data into number
        int hashCode = key.hashCode();
        // Get positive version of hashCode (in case it was a negative value)
        hashCode = Math.abs(hashCode);
        // Convert hashCode into a value within the range of slots for this map
        int destinationSlot = hashCode % map.length;
        return destinationSlot;
    }

    private static class Entry{
        private String key;
        private Integer value;

        public Entry(String key, Integer value){
            this.key = key;
            this.value = value;
        }
    }
}
