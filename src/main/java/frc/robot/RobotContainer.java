package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.SwerveJoystickCmd;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {

    private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();
    //private final XboxController driverJoystick = new XboxController(0);

    // trying with the ps4 controller 
   // private final PS4Controller driverJoystick = new PS4Controller(0);
    private final XboxController driverJoystick1 = new XboxController(0);


    // for the swerve drive when using the xbox controller axis = 1,0,4 
    // for the swerve drive when using the PS4  controller axis = 1,0,2

   public RobotContainer(){
        // For the xbox controller 
        swerveSubsystem.setDefaultCommand(new SwerveJoystickCmd(swerveSubsystem, 
       () -> driverJoystick1.getRawAxis(1),
       () -> -driverJoystick1.getRawAxis(0),
        () -> -driverJoystick1.getRawAxis(4), // 4 for the xbox controller 
       () -> driverJoystick1.getRawButton(6) ));// do do do doooooooooooooooo tx


        new JoystickButton(driverJoystick1, 5).whileTrue(new RunCommand(() -> swerveSubsystem.zeroHeading()));


    }

 /*    public RobotContainer(){
        swerveSubsystem.setDefaultCommand(new SwerveJoystickCmd(swerveSubsystem, 
       () -> driverJoystick.getRawAxis(1),
       () -> -driverJoystick.getRawAxis(0),
        () -> driverJoystick.getRawAxis(2), // 4 for the xbox controller 
       () -> driverJoystick.getRawButton(11) ));


        new JoystickButton(driverJoystick, 5).whenPressed(() -> swerveSubsystem.zeroHeading());


    }*/


    private void configureButtonBindings() {
       
    }

    /*public Command getAutonomousCommand() {
        // 1. Create trajectory settings
        TrajectoryConfig trajectoryConfig = new TrajectoryConfig(
                AutoConstants.kMaxSpeedMetersPerSecond,
                AutoConstants.kMaxAccelerationMetersPerSecondSquared)
                        .setKinematics(DriveConstants.kDriveKinematics);

        // 2. Generate trajectory
        Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
                new Pose2d(0, 0, new Rotation2d(0)),
                List.of(
                        new Translation2d(1, 0),
                        new Translation2d(1, -1)),
                new Pose2d(2, -1, Rotation2d.fromDegrees(180)),
                trajectoryConfig);

        // 3. Define PID controllers for tracking trajectory
        PIDController xController = new PIDController(AutoConstants.kPXController, 0, 0);
        PIDController yController = new PIDController(AutoConstants.kPYController, 0, 0);
        ProfiledPIDController thetaController = new ProfiledPIDController(
                AutoConstants.kPThetaController, 0, 0, AutoConstants.kThetaControllerConstraints);
        thetaController.enableContinuousInput(-Math.PI, Math.PI);

        // 4. Construct command to follow trajectory
        SwerveControllerCommand swerveControllerCommand = new SwerveControllerCommand(
                trajectory,
                swerveSubsystem::getPose,
                DriveConstants.kDriveKinematics,
                xController,
                yController,
                thetaController,
                swerveSubsystem::setModuleStates,
                swerveSubsystem);

        // 5. Add some init and wrap-up, and return everything
        return new SequentialCommandGroup(
                new InstantCommand(() -> swerveSubsystem.resetOdometry(trajectory.getInitialPose())),
                swerveControllerCommand,
                new InstantCommand(() -> swerveSubsystem.stopModules()));
    }*/
}