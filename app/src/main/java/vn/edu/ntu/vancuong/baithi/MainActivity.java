package vn.edu.ntu.vancuong.baithi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.edu.ntu.vancuong.baithi.controller.Controller;
import vn.edu.ntu.vancuong.baithi.controller.IController;

public class MainActivity extends AppCompatActivity {

    IController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new Controller();
        controller = (IController) getApplication();
    }
}