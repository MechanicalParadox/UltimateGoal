package org.firstinspires.ftc.teamcode.teleop;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.FlywheelTestMotor;
import org.firstinspires.ftc.teamcode.hardware.FullRobot;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

@TeleOp(name = "ShooterTestPower")
public class ShooterVelocityPowerTest extends LinearOpMode{
    private FullRobot robot;
    public ElapsedTime time;



    @Override
    public void runOpMode() throws InterruptedException{
        robot = new FullRobot(this, hardwareMap);
        time = new ElapsedTime();
        waitForStart();
        double powerIncrement;
        powerIncrement = 1.0;

        while(!isStopRequested()){
            /////////////////////////////////////////////////////////////////////
            //=========================GAMEPAD 1 DRIVE=========================//
            /////////////////////////////////////////////////////////////////////
            //Literally Just the Flywheel

            //Set flywheel power
            if(gamepad1.a){
                robot.flywheelTestMotor.shoot(powerIncrement);
            } else if(gamepad1.b){
                robot.flywheelTestMotor.shoot(powerIncrement - 0.15);
            } else if(gamepad1.x){
                robot.flywheelTestMotor.shoot(powerIncrement - 0.05);
            }  else if(gamepad1.y){
                robot.flywheelTestMotor.shoot(powerIncrement - 0.1);
            } else{
                robot.flywheelTestMotor.shoot(0);
            }
        }
    }
}
