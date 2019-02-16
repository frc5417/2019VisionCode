package frc.robot;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class NetworkTableTest{
    public static void main(String[] args) {
        new NetworkTableTest().run();
    }

    public void run(){
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable tableTest = inst.getTable("datatable");
        NetworkTableEntry yEntry = tableTest.getEntry("Y");
        inst.startClientTeam(190);

        tableTest.addEntryListener("X", (table, key, entry, value, flags) -> {
            System.out.println("X changed value: " + value.getValue());
        }, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

        yEntry.addListener(event -> {
            System.out.println("Y changed value: " + event.value.getValue());
        }, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);
        
        try{
            Thread.sleep(100000);
        } catch (InterruptedException ex){
            System.out.println("interrupted!");
            return;
        }
    }
}