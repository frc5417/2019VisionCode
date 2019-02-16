
package frc.robot;
//package networktablesdesktopclient;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class RobotVision extends TimedRobot{
  NetworkTableEntry xEntry;
  NetworkTableEntry yEntry;

  public void robotInit(){
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("datatable");
    xEntry = table.getEntry("X");
    yEntry = table.getEntry("Y");
  }

  double x = 0;
  double y = 0;

  public void teleopPeriodic(){
    xEntry.setDouble(x);
    yEntry.setDouble(y);
    x += 0.05;
    y += 1.0;
  }
}
/*public class RobotVision {
  public static void main(String[] args) {
    new NetworkTablesDesktopClient().run();
  }

  public void run() {
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("datatable");
    NetworkTableEntry xEntry = table.getEntry("x");
    NetworkTableEntry yEntry = table.getEntry("y");

    inst.startClientTeam(5417);  // where TEAM=190, 294, etc, or use inst.startClient("hostname") or similar
    inst.startDSClient();  // recommended if running on DS computer; this gets the robot IP from the DS

    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        System.out.println("interrupted");
        return;
      }

      double x = xEntry.getDouble(0.0);
      double y = yEntry.getDouble(0.0);
      System.out.println("X: " + x + " Y: " + y);
    }
  }
}*/

/*package frc.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class RobotVision extends SampleRobot {
  NetworkTable table;
    public RobotVision(){
      table = NetworkTable.getTable("ChickenVision");
      System.out.print("startaaa");
    }
    public void robotInit() {
      double[] defaultValue = new double[0];
      while(true){
        String key = "tapeYaw";
        double[] currentAngles = table.getNumberArray(key, defaultValue);
        System.out.print("Angle is " + currentAngles);
        for (double currentAngle : currentAngles){
          System.out.print(currentAngle + " ");
      }
    }        
  } 
}*/