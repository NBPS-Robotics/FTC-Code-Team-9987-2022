package org.firstinspires.ftc.teamcode.Vision;

import com.arcrobotics.ftclib.vision.UGContourRingPipeline;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

public class Camera {
    private static final int CAMERA_WIDTH = 320; // width  of wanted camera resolution
    private static final int CAMERA_HEIGHT = 240; // height of wanted camera resolution

    private static final int HORIZON = 100; // horizon value to tune

    private static final boolean DEBUG = false; // if debug is wanted, change to true
    private static final String WEBCAM_NAME = "Webcam 1"; // insert webcam name from configuration if using webcam

    private static UGContourRingPipeline pipeline; //create pipeline object
    private static OpenCvCamera camera; //create camera object
    public static Servo cam; //create servo object

    public static void init(HardwareMap hardwareMap, Telemetry telemetry){
        cam = hardwareMap.servo.get("Cam"); //initialize the camera servo
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory
                .getInstance()
                .createWebcam(hardwareMap.get(WebcamName.class, WEBCAM_NAME), cameraMonitorViewId); //configure the camera
        camera.setPipeline(pipeline = new UGContourRingPipeline(telemetry, DEBUG)); //pipeline config

        UGContourRingPipeline.Config.setCAMERA_WIDTH(CAMERA_WIDTH); //set camera width

        UGContourRingPipeline.Config.setHORIZON(HORIZON); //set the horizon

        //camera.openCameraDeviceAsync(() -> camera.startStreaming(CAMERA_WIDTH, CAMERA_HEIGHT, OpenCvCameraRotation.UPRIGHT)); //set up camera stream
     }

    /**
     * This function returns the height of the stack the camera detects
     * @return height of the stack
     */
     public static UGContourRingPipeline.Height getHeight(){
        return pipeline.getHeight();
     }

    /**
     * This function moves the camera out to detect objects
     */
    public static void out(){
        cam.setPosition(0.935);
    }

    /**
     * This function moves the camera in when its not needed
     */
     public static void in(){
        cam.setPosition(0.2);
    }
}
