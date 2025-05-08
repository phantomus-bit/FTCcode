package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous
public class autonomus_1 extends LinearOpMode {

    private DcMotor motor1 = null;
    private DcMotor motor2 = null;
    private DcMotor motor3 = null;
    private DcMotor hex = null;


    @Override
    public void runOpMode() throws InterruptedException {

        motor1 = hardwareMap.get(DcMotor.class, "motorLeft");
        motor2 = hardwareMap.get(DcMotor.class, "motorRight");


        // Wait for the start button to be pressed
        waitForStart();

        // Set both motors to move forward
        motor1.setPower(-0.5);  // Adjust power as needed (0.0 to 1.0)
        motor2.setPower(0.5);

        sleep(1000);  // Move forward for 1 second (1000 milliseconds)

        // Stop the motors
        motor1.setPower(0.5);
        motor2.setPower(0);

        sleep(600);

        motor1.setPower(-0.5);
        motor2.setPower(0.5);

        sleep(1600);


       motor1.setPower(-0.5);
       motor2.setPower(0);

       sleep(920);

     motor1.setPower(0.7);
     motor2.setPower(-0.7);

       sleep(1600);

       motor1.setPower(-0.7);
       motor2.setPower(0.7);

       sleep(1500);
        motor1.setPower(0.5);
        motor2.setPower(0.5);

        sleep(400);

        motor1.setPower(-0.5);
        motor2.setPower(0.5);

        sleep(800);

        motor1.setPower(-0.5);
        motor2.setPower(-0.5);

        sleep(400);

        motor1.setPower(0.7);
        motor2.setPower(-0.7);

        sleep(1700);



        motor1.setPower(0);
        motor2.setPower(0);


    }
}


