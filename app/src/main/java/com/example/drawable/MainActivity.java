package com.example.drawable;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private float scale = 1f; // For scaling the image
    private float originalX, originalY, originalScaleX, originalScaleY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.myImageView);

        // Store original position and scale
        originalX = imageView.getX();
        originalY = imageView.getY();
        originalScaleX = imageView.getScaleX();
        originalScaleY = imageView.getScaleY();

        Button moveLeftButton = findViewById(R.id.moveLeftButton);
        Button moveRightButton = findViewById(R.id.moveRightButton);
        Button moveUpButton = findViewById(R.id.moveUpButton);
        Button moveDownButton = findViewById(R.id.moveDownButton);
        Button zoomInButton = findViewById(R.id.zoomInButton);
        Button zoomOutButton = findViewById(R.id.zoomOutButton);
        Button restoreButton = findViewById(R.id.restoreButton);

        zoomInButton.setOnClickListener(v -> zoomImage(1.4f)); // Zoom in by 40%
        zoomOutButton.setOnClickListener(v -> zoomImage(0.6f)); // Zoom out by 40%
        restoreButton.setOnClickListener(v -> restoreImage());


        // Implement move left functionality
        moveLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move the ImageView Left by 30 pixels
                imageView.setX(imageView.getX() - 30);
            }
        });

        // Implement move right functionality
        moveRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move the ImageView Right by 30 pixels
                imageView.setX(imageView.getX() + 30);
            }
        });

        // Implement move up functionality
        moveUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move the ImageView up by 30 pixels
                imageView.setY(imageView.getY() - 30);
            }
        });

        // Implement move down functionality
        moveDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move the ImageView down by 30 pixels
                imageView.setY(imageView.getY() + 30);
            }
        });

        // Implement restore functionality
        restoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restoreImage();
            }
        });
    }

    private void zoomImage(float scaleFactor) {
        scale *= scaleFactor;
        imageView.setScaleX(scale);
        imageView.setScaleY(scale);
    }

    private void restoreImage() {
        scale = 1f;
        imageView.setX(originalX);
        imageView.setY(originalY);
        imageView.setScaleX(originalScaleX);
        imageView.setScaleY(originalScaleY);
    }
}