package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

//import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;

@TeleOp
public class XNERO extends OpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    DcMotor hex;

    DcMotorEx motor1;
    //static final double MAX_VELOCITY = 2800;
  //  static final double V_HEX = 2800;

    double h_power = 1;


    @Override
    public void init() {
        frontLeft  = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft   = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight  = hardwareMap.get(DcMotorEx.class, "backRight");
        hex = hardwareMap.get(DcMotor.class, "hex");
        // Reverse left side

        // Reset encoders
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Run using encoders
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Brake when stopped
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


//        hex = hardwareMap.get(DcMotor.class, "hex");
      //  hex.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

       // motor1 = hardwareMap.get(DcMotorEx.class, "motor1");

        // Reset encoder
      //  motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Enable encoder velocity control
      //  motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

      //  motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      //  hex.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Enable encoder velocity control
     //   hex.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

      //  hex.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        // Reverse one side so the robot moves correctly
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
// Gamepad input
        double y  = -gamepad1.left_stick_y; // forward
        double x  =  gamepad1.left_stick_x; // strafe
        double rx =  gamepad1.right_stick_x; // turn

        // Mecanum math
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.0);

        double fl = (-y + x + rx) / denominator;
        double bl = (-y - x + rx) / denominator;
        double fr = (-y - x - rx) / denominator;
        double br = (-y + x - rx) / denominator;

        // Power-based control (simple & reliable)
        frontLeft.setPower(fl);
        backLeft.setPower(bl);
        frontRight.setPower(fr);
        backRight.setPower(br);



        if (gamepad2.dpad_up){
            hex.setPower(h_power);

        }
        if (gamepad2.dpad_down){
            hex.setPower(-h_power);
        }
        if(gamepad1.right_bumper){
            h_power += 0.1;}
        else if(gamepad1.left_bumper){
            h_power -= 0.1;
        }

        //motor1.setPower(0);
        hex.setPower(0);

    }
}
