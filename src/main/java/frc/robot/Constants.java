package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

public final class Constants {

    public static final class ModuleConstants {
        public static final double kWheelDiameterMeters = Units.inchesToMeters(4);
        // On the previous code 1/5.8462
        // On the previous code 6.75
        public static final double kDriveMotorGearRatio = 1 / 6.75;
        // On the previous code said 1/18
        public static final double kTurningMotorGearRatio = 1 / 12.8;
        public static final double kDriveEncoderRot2Meter = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters;
        public static final double kTurningEncoderRot2Rad = kTurningMotorGearRatio * 2 * Math.PI;
        public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter / 60;
        public static final double kTurningEncoderRPM2RadPerSec = kTurningEncoderRot2Rad / 60;
// PID found in the Swerve Module line 56 ]\[

//][\]
        public static final double kPTurning = 0.3;

    }

    public static final class DriveConstants {

        public static final double kTrackWidth = Units.inchesToMeters(14.5);
        // Distance between right and left wheels
        public static final double kWheelBase = Units.inchesToMeters(17.5);
        // Distance between front and back wheels

                static Translation2d frontLeft = new Translation2d(0.323, 0.323);
                static Translation2d backLeft = new Translation2d(-0.323, 0.323);
                static Translation2d frontRight = new Translation2d(0.323, -0.323);
                static  Translation2d backRight = new Translation2d(-0.323, -0.323);
                public static final double tick2Feet = 1.0 / 4096 * 6  * Math.PI / 12;

        public final static SwerveDriveKinematics kDrivekinematics = new SwerveDriveKinematics(
                    frontLeft, backLeft, frontRight, backRight
                  );


        public static final int kFrontLeftDriveMotorPort = 6;// 6 //4
        public static final int kBackLeftDriveMotorPort = 8; // 8 
        public static final int kFrontRightDriveMotorPort = 4; // 4  // 6 
        public static final int kBackRightDriveMotorPort = 2;
//Change the modules for turning on the left side 
// unplug the front left module and put it on the back left and vise versa 
// Should work considering that 
// Or change the can id on them making sure that they can run 
// Might not match the phyisical robot but will work and thats what we need. 
        public static final int kFrontLeftTurningMotorPort = 5;// used to be 5 // 7 
        public static final int kBackLeftTurningMotorPort = 7; // used to be 7  // 5 
        public static final int kFrontRightTurningMotorPort = 3;//3

        // Switched out for the front left one 
        public static final int kBackRightTurningMotorPort = 1; //1
// THe drive ones are running well but the turning encoders are in pair of back and front sets 
// Turning encoders 
        public static final boolean kFrontLeftTurningEncoderReversed = false;
        public static final boolean kBackLeftTurningEncoderReversed = true;
//
        public static final boolean kFrontRightTurningEncoderReversed = false;
        public static final boolean kBackRightTurningEncoderReversed = false;
// Drive encoders 
        public static final boolean kFrontLeftDriveEncoderReversed = false;
        public static final boolean kBackLeftDriveEncoderReversed = true;
        // Was false trying true 
        // Front right module everytime that is reset the encoder reads the opposite needs to be flipped
        public static final boolean kFrontRightDriveEncoderReversed = true;
        public static final boolean kBackRightDriveEncoderReversed = true;
     

        public static final int kFrontLeftDriveAbsoluteEncoderPort = 20;//2
        public static final int kBackLeftDriveAbsoluteEncoderPort = 21;//3
        public static final int kFrontRightDriveAbsoluteEncoderPort = 23;
        public static final int kBackRightDriveAbsoluteEncoderPort =22;

        public static final boolean kFrontLeftDriveAbsoluteEncoderReversed = true;
        public static final boolean kBackLeftDriveAbsoluteEncoderReversed = true;
        public static final boolean kFrontRightDriveAbsoluteEncoderReversed = true;
        public static final boolean kBackRightDriveAbsoluteEncoderReversed = true;
// This is for the absolute encoders 
        public static final double kFrontLeftDriveAbsoluteEncoderOffsetRad = -0.0237;// used to be 1.254
        public static final double kBackLeftDriveAbsoluteEncoderOffsetRad = -0.0377; // used to be 0.252
        public static final double kFrontRightDriveAbsoluteEncoderOffsetRad = 0.234; // used to be -1.816
        public static final double kBackRightDriveAbsoluteEncoderOffsetRad = .0221; // used to be -4.811
// Speed gets divided below 
        public static final double kPhysicalMaxSpeedMetersPerSecond = 4;
        // Angle radians 
        public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2 * 2 * Math.PI;
// Speed for the driving 
        public static final double kTeleDriveMaxSpeedMetersPerSecond = kPhysicalMaxSpeedMetersPerSecond / 2;
        // Speed for the angular 
        public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = //
                kPhysicalMaxAngularSpeedRadiansPerSecond / 2;
        // Acceleration speeds. 
        public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 4;
            
            

            
        public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 4;
    }

    public static final class AutoConstants {
        public static final double kMaxSpeedMetersPerSecond = DriveConstants.kPhysicalMaxSpeedMetersPerSecond / 4;
        public static final double kMaxAngularSpeedRadiansPerSecond = //
                DriveConstants.kPhysicalMaxAngularSpeedRadiansPerSecond / 10;
        public static final double kMaxAccelerationMetersPerSecondSquared = 3;
        public static final double kMaxAngularAccelerationRadiansPerSecondSquared = Math.PI / 4;
        public static final double kPXController = 1.5;
        public static final double kPYController = 1.5;
        public static final double kPThetaController = 3;

        public static final TrapezoidProfile.Constraints kThetaControllerConstraints = //
                new TrapezoidProfile.Constraints(
                        kMaxAngularSpeedRadiansPerSecond,
                        kMaxAngularAccelerationRadiansPerSecondSquared);
    }

    public static final class OIConstants {
        public static final int kDriverControllerPort = 0;

        public static final int kDriverYAxis = 1;
        public static final int kDriverXAxis = 0;
        public static final int kDriverRotAxis = 4;
        public static final int kDriverFieldOrientedButtonIdx = 1;

        public static final double kDeadband = 0.09;
    }
}