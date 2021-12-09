package org.firstinspires.ftc.teamcode.Vision;

import com.arcrobotics.ftclib.vision.UGContourRingPipeline;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

import java.util.List;

public class Camera {

    private static final String TFOD_MODEL_ASSET = "FreightFrenzy_BCDM.tflite";
    private static final String[] LABELS = {
            "Ball",
            "Cube",
            "Duck",
            "Marker"
    };
    private static final String VUFORIA_KEY =
            "AW7vQeL/////AAABmZpV+TNdzEfigTTiCS83WyFkYs/PO6Vt1jU0nmyH+MkdBjFiWRCtrz2eL6Dx0LsXgcfEn4iF52EM1s86ALJgZOFpycoesjV/VDzvwjHY+b0gPTTtBwaioglg3HY1rwHz3po8fmRqtDmVqhNG+jYfmwVzi2Suygk8RM0f27sbt1rpZhl08Q+PR+sDV5LirITAa3CKsyISroBs39r+Z1M1XLOvtG0BUKxZWq9ht7z0dCR1bJ1Y2+HaaOodCxz7DZU644E+KlM0PsYidbqb/mhN+Ec17a39TPACFEVrKCYFNsLPFAkcyceJegGpYb3lHp8h/kVoBZ2cZVWq5MDlUpym/QqxhlpcJ4kWuHmGPR4TTpv/";

    /**
     * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
     * localization engine.
     */
    private static VuforiaLocalizer vuforia;

    /**
     * {@link #tfod} is the variable we will use to store our instance of the TensorFlow Object
     * Detection engine.
     */
    private static TFObjectDetector tfod;

    public static void init(HardwareMap hardwareMap, Telemetry telemetry){
        initVuforia(hardwareMap);
        initTfod(hardwareMap);
        if (tfod != null) {
            tfod.activate();
            tfod.setZoom(1, 16.0/9.0);
        }
        telemetry.addData("Camera Ready", ""); //report camera working
        telemetry.update();
     }


     public static String getTeamElementPosition(String position){
        String duck = getPosition();
        if(position == "Left"){
            if(duck.equals("Left")) return "Left";

            else if(duck.equals("Right")) return "Center";

            else return "Right";
        }
         else if(position == "Right"){
             if(duck.equals("Left")) return "Center";

             else if(duck.equals("Right")) return "Right";

             else return "Left";
         }
        else return null;
     }
     public static String getPosition(){
         if (tfod != null) {
             // getUpdatedRecognitions() will return null if no new information is available since
             // the last time that call was made.
             List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
             if (updatedRecognitions != null) {
                 // step through the list of recognitions and display boundary info.
                 int i = 0;
                 for (Recognition recognition : updatedRecognitions) {
                     if(recognition.getLabel().equals("Duck")){
                         boolean pose = checkPose(recognition.getLeft());
                         if(pose) return "Right";
                         else return "Left";
                     }

                     i++;
                 }
             }
         }
        return "None";
    }

     public static boolean checkPose(double pixel){
         if(pixel >= 180) return true; // on the right
         else return false; //on the left
     }
    private static void initVuforia(HardwareMap hardwareMap) {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

    /**
     * Initialize the TensorFlow Object Detection engine.
     */
    private static void initTfod(HardwareMap hardwareMap) {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.8f;
        tfodParameters.isModelTensorFlow2 = true;
        tfodParameters.inputSize = 320;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
    }

}
