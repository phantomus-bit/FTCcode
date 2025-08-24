package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous
public class color extends LinearOpMode {

    private DcMotor motor1 = null;
    private DcMotor motor2 = null;
    private DcMotor motor3;
    private DcMotor hex = null;
    private Servo servo1;

    public static String red() {
        return null;
    }

    public static String green() {
        return null;
    }
    public static String blue(){
        return null;
    }


    @Override
    public void runOpMode() {
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        hex = hardwareMap.get(DcMotor.class, "hex");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        ColorSensor color  = hardwareMap.get(ColorSensor.class, "color");
    }}
