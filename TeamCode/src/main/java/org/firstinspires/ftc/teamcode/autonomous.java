package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class autonomous extends LinearOpMode {

    private DcMotor motorLeft;
    private DcMotor motorRight;
    private DcMotor motor3;
    private DcMotor hex;
    private Servo servo1;
    private Servo servo2;

    @Override
    public void runOpMode() throws InterruptedException {

        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        hex = hardwareMap.get(DcMotor.class, "hex");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");

        double holdPower = 0.1;

        waitForStart();  // Wait for the start signal

        if (opModeIsActive()) {
            holdObject1();
            holdObject2();

            sleep(2000);  // Hold for 2 seconds

            motorLeft.setPower(0.6);
            motorRight.setPower(-0.6);

            sleep(540);  // Move for a brief time

            motorLeft.setPower(0);
            motorRight.setPower(0);

            sleep(300);
            hex.setPower(0.8);
            motor3.setPower(-0.65);

            wait(100);  // Custom wait method (100 milliseconds)

            sleep(300);  // Sleep for 300ms

            hex.setPower(0);
            motor3.setPower(0);

            sleep(300);

            releaseObject1();
            releaseObject2();
        }
    }

    // Method to make the first servo hold the object
    private void releaseObject1() {
        servo1.setPosition(0.7);  // Position to hold the object (adjust based on your setup)
    }

    // Method to make the second servo hold the object
    private void releaseObject2() {
        servo2.setPosition(0.7);  // Position to hold the object (adjust based on your setup)
    }

    // Method to release the first object
    private void holdObject1() {
        servo1.setPosition(0.52);  // Position to release the object (adjust based on your setup)
    }

    // Method to release the second object
    private void holdObject2() {
        servo2.setPosition(0.88);  // Position to release the object (adjust based on your setup)
    }

    // Custom wait method (like sleep but implemented manually)
    private void wait(int milliseconds) throws InterruptedException {
        long endTime = System.currentTimeMillis() + milliseconds;
        while (opModeIsActive() && System.currentTimeMillis() < endTime) {
            // This loop will keep running until the specified wait time is over
            idle();  // Allows other tasks to run while waiting
        }
    }
}


//BLABLABLA BLEBLEBLE BLUBLUBUUU HA BULI BULI BULIBULIBULIBULIBULIBULIBULIBULIBULIBULIBULIBULIBULIBULIBULIBULIBULIBULIBULI