package org.firstinspires.ftc.teamcode.hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDrive {
    public static DcMotorEx frontR;
    public static DcMotorEx frontL;
    public static DcMotorEx backR;
    public static DcMotorEx backL;

    LinearOpMode OpMode;

    public MecanumDrive(FullRobot robot, HardwareMap map, LinearOpMode OpMode){
        //super(telemetry);
        this.OpMode = OpMode;
// match with phone names
        frontR = map.get(DcMotorEx.class, "FR");
        frontL = map.get(DcMotorEx.class, "FL");
        backR = map.get(DcMotorEx.class, "BR");
        backL = map.get(DcMotorEx.class, "BL");

//epic brake power
        frontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//set drivetrain motors to run without encoder
        frontR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

//reset drivetrain encoders
    public void reset() {
        frontL.setPower(0);
        frontR.setPower(0);
        backL.setPower(0);
        backR.setPower(0);

        frontL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

//determine encoder changes
    public double getRawLeftPosition() {
        return frontR.getCurrentPosition();
    }

    public double getRawCenterPosition() {
        return backR.getCurrentPosition();
    }

    public double getRawRightPosition() {
        return -backL.getCurrentPosition();
    }
}
