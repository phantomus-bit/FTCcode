package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.List;

public interface uhm {
    List<DcMotor> getMotors();

    void update();
}
