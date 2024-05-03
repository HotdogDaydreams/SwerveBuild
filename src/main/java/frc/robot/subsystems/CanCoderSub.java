package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class CanCoderSub extends SubsystemBase{
    private CANcoder absoluteEncoder;



@Override 
public void periodic(){
readEncoder(20);
readEncoder(21);
readEncoder(22);
readEncoder(23);
}
public  double getEncoderPosition(){

    var AbsolutePositionsignal = absoluteEncoder.getAbsolutePosition();
    var AbsolutePosition = AbsolutePositionsignal.getValue();
return AbsolutePosition;
}
public void readEncoder(int absoluteEncoderId){
     absoluteEncoder = new CANcoder(absoluteEncoderId);
     SmartDashboard.putNumber("Encoder #[" + absoluteEncoder.getDeviceID() + "] Encoder Position", getEncoderPosition());
}
}

