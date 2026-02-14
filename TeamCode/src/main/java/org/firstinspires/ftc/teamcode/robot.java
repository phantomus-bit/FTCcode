//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.Range;
//
//
//@TeleOp(name = "XNERO")
//public class robot extends OpMode {
//
//    //public Servo servo1;
//  //  public Servo servo2;
//    DcMotor motorLeft;
//    DcMotor motorRight;
//    DcMotor motor3;
//    DcMotor hex;
//
//    private double motor3Power = 0;
//    private double hexPower = 0;
//    private boolean motor3Moving = false;
//    private boolean hexMoving = false;
//
//    private double hldPower = 0.2;
//
//    @Override
//    public void init() {
//        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
//        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
//        motor3 = hardwareMap.get(DcMotor.class, "motor3");
//        hex = hardwareMap.get(DcMotor.class, "hex");
//        //servo1 = hardwareMap.get(Servo.class, "servo1");
//       // servo2 = hardwareMap.get(Servo.class, "servo2");
//        motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        motor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        hex.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        telemetry.addData("Motors", "connected");
//        double holdPower = 0.1;
//        hex.setPower(holdPower);
//
//    }
//
//    @Override
//    public void loop() {
//
//        telemetry.update();
//        double drive = -gamepad1.right_stick_x; // Forward/backward control
//        double turn  = gamepad1.left_stick_y;   // Left/right turning
//
//        double leftPower  = Range.clip(drive - turn, -1.0, 1.0);
//        double rightPower = Range.clip(drive + turn, -1.0, 1.0);
//
//        motorLeft.setPower(leftPower);
//        motorRight.setPower(rightPower);
//
//
//        // Servo1 control triggered by triggers
//        if (gamepad2.left_trigger > 0){
//
//           // servo1.setPosition(0.50);//open
//         // servo2.setPosition(0.8);
//        } else if (gamepad2.right_trigger > 0) {
//
//           //servo1.setPosition(0.4);//close
//          // servo2.setPosition(1);
//        }
//        // Motor3 control (controlled by D-pad)
//        if(gamepad2.dpad_up && !motor3Moving){
//            motor3.setPower(-0.6);
//            motor3Power = -0.5;
//            motor3Moving = true;
//        } else if(gamepad2.dpad_down && !motor3Moving){
//            motor3.setPower(0.6);
//            motor3Power = (0.5);
//        }
//            motor3Moving = true;
//
//
//        if (!gamepad2.dpad_up && !gamepad2.dpad_down) {
//            motor3.setPower(0);
//
//            motor3Moving = false;
//        }
//
//
//        if(gamepad2.dpad_left && !hexMoving){
//            hex.setPower(0.6);
//            hexPower = 1;
//            hexMoving = true;
//        } else if(gamepad2.dpad_right && !hexMoving) {
//            hex.setPower(-0.6);
//            hexPower = -1;
//            hexMoving = true;
//        }
//
//        if (!gamepad2.dpad_left && !gamepad2.dpad_right && hexMoving) {
//            hex.setPower(0.1);
//            hexMoving = false;
//        }
//
//
//        telemetry.update();
//    }
//}
//
