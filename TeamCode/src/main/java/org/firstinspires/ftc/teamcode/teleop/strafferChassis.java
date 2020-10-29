package org.firstinspires.ftc.teamcode.teleop;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.FullRobot;

@TeleOp(name = "drivetrain")
public class strafferChassis extends LinearOpMode {
    private FullRobot robot;
    public ElapsedTime time;

    @Override
    public void runOpMode() throws InterruptedException{
        robot = new FullRobot(this, hardwareMap);
        time = new ElapsedTime();
    }
}
