package utils;

public class ContactHashMap {
    private static final int INITIAL_SIZE = 103;
    private Entry [] map;
    private int count;

    public ContactHashMap(){
        map = new Entry[INITIAL_SIZE];
        count = 0;
    }

    public void put(String key, Integer value){
        validateKey(key);

        // Call dedicated method to calculate the appropriate destination for the value
        // This adheres to single responsibility principle
        int destinationSlot = calculateSlot(key);

        // If the slot is available
        if(map[destinationSlot] == null){
            // Create an entry to hold the key and value within the map
            Entry newEntry = new Entry(key, value);
            // Add that entry to the map in the calculated destination slot
            map[destinationSlot] = newEntry;
        }
    }

    public Integer get(String key){
        validateKey(key);

        // Call dedicated method to calculate the appropriate destination for the value
        // This adheres to single responsibility principle
        int destinationSlot = calculateSlot(key);

        if(map[destinationSlot] == null){
            return null;
        }

        return map[destinationSlot].value;
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
