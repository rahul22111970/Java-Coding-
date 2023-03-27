import java.util.*;

public class ParkingSystem {
    private final int MAX_SLOTS = 32;
    private final int PARKING_COST_PER_HOUR = 30;
    private final Map<Integer, String> parkingSlots = new HashMap<>();
    private final Map<Integer, Date> parkingSlotAvailability = new HashMap<>();
    
    public ParkingSystem() {
        for(int i = 1; i <= MAX_SLOTS; i++) {
            parkingSlots.put(i, "");
            parkingSlotAvailability.put(i, null);
        }
    }
    
    public boolean isSlotAvailable() {
        for(int i = 1; i <= MAX_SLOTS; i++) {
            if(parkingSlots.get(i).isEmpty()) {
                return true;
            }
        }
        return false;
    }
    
    public int bookSlot(String vehicleNumber) {
        for(int i = 1; i <= MAX_SLOTS; i++) {
            if(parkingSlots.get(i).isEmpty()) {
                parkingSlots.put(i, vehicleNumber);
                parkingSlotAvailability.put(i, new Date());
                return i;
            }
        }
        return -1;
    }
    
    public boolean releaseSlot(int slotNumber) {
        if(!parkingSlots.get(slotNumber).isEmpty()) {
            parkingSlots.put(slotNumber, "");
            parkingSlotAvailability.put(slotNumber, null);
            return true;
        }
        return false;
    }
    
    public int calculateParkingCost(int slotNumber) {
        Date start = parkingSlotAvailability.get(slotNumber);
        Date end = new Date();
        long durationInMillis = end.getTime() - start.getTime();
        int hours = (int)(durationInMillis / (60 * 60 * 1000));
        if(hours == 0) {
            hours = 1;
        }
        return hours * PARKING_COST_PER_HOUR;
    }
    
    public Map<Integer, String> getParkingSlots() {
        return parkingSlots;
    }
    
    public Map<Integer, Date> getParkingSlotAvailability() {
        return parkingSlotAvailability;
    }
}
