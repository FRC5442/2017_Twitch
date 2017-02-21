package baseCommands;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivePID extends PIDSubsystem{
	
	public double drive_speed;

	public DrivePID() {
		super("DriveStraight", 1, 0, 0);
		setAbsoluteTolerance(10.0);
		setOutputRange(-1, 1);
		LiveWindow.addActuator("Drive Train", "Drive Straight", getPIDController());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return RobotMap.navX.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		RobotMap.driveTrainRobotDrive.drive(drive_speed, output);	
		SmartDashboard.putNumber("PID Output", output);
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
