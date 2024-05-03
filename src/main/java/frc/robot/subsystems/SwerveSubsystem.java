package frc.robot.subsystems;


import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Pose2d;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class SwerveSubsystem extends SubsystemBase {


    private final SwerveModule frontLeft = new SwerveModule(
            DriveConstants.kFrontLeftDriveMotorPort,
            DriveConstants.kFrontLeftTurningMotorPort,
            // aw hell nah
            DriveConstants.kFrontLeftDriveEncoderReversed,
            DriveConstants.kFrontLeftTurningEncoderReversed,
            DriveConstants.kFrontLeftDriveAbsoluteEncoderPort,
            DriveConstants.kFrontLeftDriveAbsoluteEncoderOffsetRad,
            DriveConstants.kFrontLeftDriveAbsoluteEncoderReversed);


    private final SwerveModule backLeft = new SwerveModule(
            DriveConstants.kBackLeftDriveMotorPort,
            DriveConstants.kBackLeftTurningMotorPort,
            DriveConstants.kBackLeftDriveEncoderReversed,
            DriveConstants.kBackLeftTurningEncoderReversed,
            DriveConstants.kBackLeftDriveAbsoluteEncoderPort,
            DriveConstants.kBackLeftDriveAbsoluteEncoderOffsetRad,
            DriveConstants.kBackLeftDriveAbsoluteEncoderReversed);


    private final SwerveModule frontRight = new SwerveModule(
            DriveConstants.kFrontRightDriveMotorPort,
            DriveConstants.kFrontRightTurningMotorPort,
            DriveConstants.kFrontRightDriveEncoderReversed,
            DriveConstants.kFrontRightTurningEncoderReversed,
            DriveConstants.kFrontRightDriveAbsoluteEncoderPort,
            DriveConstants.kFrontRightDriveAbsoluteEncoderOffsetRad,
            DriveConstants.kFrontRightDriveAbsoluteEncoderReversed);

    private final SwerveModule backRight = new SwerveModule(
            DriveConstants.kBackRightDriveMotorPort,
            DriveConstants.kBackRightTurningMotorPort,
            DriveConstants.kBackRightDriveEncoderReversed,
            DriveConstants.kBackRightTurningEncoderReversed,
           DriveConstants.kBackRightDriveAbsoluteEncoderPort,
           DriveConstants.kBackRightDriveAbsoluteEncoderOffsetRad,
           DriveConstants.kBackRightDriveAbsoluteEncoderReversed);

    public AHRS navX = new AHRS(SPI.Port.kMXP);
    //private final SwerveDriveOdometry m_odometry; 

    //private final SwerveDriveOdometry odometer = new SwerveDriveOdometry(DriveConstants.kDrivekinematics, 
  //  new Rotation2d(0));




public SwerveModulePosition[] getModulePositions(){

    return( new SwerveModulePosition[]{
      frontLeft.getPosition(), 
      backLeft.getPosition(), 
      frontRight.getPosition(),
      backRight.getPosition()});

  }



    

 public SwerveSubsystem() {


   // m_odometry = new SwerveDriveOdometry(DriveConstants.kDrivekinematics, navX.getRotation2d(), getModulePositions());

  /*  SwerveDriveOdometry odometry = new SwerveDriveOdometry(DriveConstants.kDrivekinematics, navX.getRotation2d(),
   new SwerveModulePosition[]{
    frontLeft.getPosition(),
    backLeft.getPosition(),
    frontRight.getPosition(),
    backRight.getPosition()
   });*/
   // getModulePositions());

        
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                zeroHeading();
            } catch (Exception e) {
            }
        }).start();
    }

   
    public void zeroHeading() {
        navX.reset();
    }

    public double getHeading() {
       //  Return not working 
        return Math.IEEEremainder(navX.getAngle(), 360);
    }

    public Rotation2d getRotation2d() {
        return Rotation2d.fromDegrees(getHeading());
    }

 //  public Pose2d getPose() {
        //return m_odometry.getPoseMeters();
   // }

    public void resetOdometry(Pose2d pose) {
       // odometry.resetPose(pose, getRotation2d());
    }

    @Override
    public void periodic() {

         // Get the rotation of the robot from the gyro.
         var gyroAngle = navX.getRotation2d(); 
         // Update the pose
    // m_pose = odometry.update(gyroAngle,
   //new SwerveModulePosition[]{frontLeft.getPosition(),
    //backLeft.getPosition(),
    //frontRight.getPosition(),
    //backRight.getPosition()});

//   m_frontLeftModule.getposition(), m_frontRightModule.getposition(), m_backLeftModule.getposition(),  m_backRightModule.getposition()}
   
   //),

       // odometer.update(getRotation2d(), frontLeft.getState(), frontRight.getState(), backLeft.getState(),backRight.getState());
        SmartDashboard.putNumber("Robot Heading", getHeading());
        
      
    }

    public void stopModules() {
        frontLeft.stop();
        backLeft.stop();
        frontRight.stop();
        backRight.stop();
    }

     public void setModuleStates(SwerveModuleState[] desiredStates) {
       SwerveDriveKinematics.desaturateWheelSpeeds(desiredStates, DriveConstants.kPhysicalMaxSpeedMetersPerSecond);

        
        frontLeft.setDesiredState(desiredStates[2]);
        backLeft.setDesiredState(desiredStates[3]);
        frontRight.setDesiredState(desiredStates[1]);
        backRight.setDesiredState(desiredStates[0]);
    }
    public SwerveModule getFrontLeft() {
        return frontLeft;
    }
    public SwerveModule getBackLeft() {
        return backLeft;
    }
    public SwerveModule getFrontRight() {
        return frontRight;
    }
    public SwerveModule getBackRight() {
        return backRight;
    }
   
    public AHRS getNavX() {
        return navX;
    }

}