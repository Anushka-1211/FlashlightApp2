package com.example.flashlightapp;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

private ToggleButton flashLightToggle;
private String cameraId;
private CameraManager cameraManager;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
EdgeToEdge.enable(this);
setContentView(R.layout.activity_main);
flashLightToggle = findViewById(R.id.togglebutton);
cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
try {
cameraId = cameraManager.getCameraIdList()[0];
} catch (CameraAccessException e) {
e.printStackTrace();
}
flashLightToggle.setOnCheckedChangeListener((view, state) -> {
try {
if (state) {
    cameraManager.setTorchMode(cameraId, true);
    Toast.makeText(this, "Flashlight On", Toast.LENGTH_SHORT).show();
} else {
    cameraManager.setTorchMode(cameraId, false);
    Toast.makeText(this, "Flashlight Off", Toast.LENGTH_SHORT).show();
}
} catch (CameraAccessException e) {
e.printStackTrace();
}
});
}
}


