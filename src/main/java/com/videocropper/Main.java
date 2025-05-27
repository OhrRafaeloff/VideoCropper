package com.videocropper;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.geometry.Insets;

public class Main extends Application {
    private MediaPlayer mediaPlayer;
    private MediaView mediaView;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER); // Center align all components

        // Create media controls
        HBox controls = new HBox(10);
        controls.setAlignment(Pos.CENTER); // Center align buttons
        Button loadButton = new Button("Load Video");
        Button playButton = new Button("Play");
        Button cropButton = new Button("Crop");

        controls.getChildren().addAll(loadButton, playButton, cropButton);

        // Create MediaView with initial size
        mediaView = new MediaView();
        mediaView.setFitWidth(640);
        mediaView.setFitHeight(480);
        mediaView.setPreserveRatio(true);

        // Add components to root
        root.getChildren().addAll(mediaView, controls);

        // Handle load video button
        loadButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.avi", "*.mkv")
            );

            java.io.File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    Media media = new Media(file.toURI().toString());
                    if (mediaPlayer != null) {
                        mediaPlayer.dispose();
                    }
                    mediaPlayer = new MediaPlayer(media);
                    mediaPlayer.setOnError(() -> showError("Error playing video",
                            mediaPlayer.getError().toString()));
                    mediaView.setMediaPlayer(mediaPlayer);
                    mediaPlayer.setAutoPlay(false);
                    playButton.setText("Play");
                } catch (Exception ex) {
                    showError("Error loading video", ex.getMessage());
                }
            }
        });

        // Handle play button
        playButton.setOnAction(e -> {
            if (mediaPlayer != null) {
                if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                    mediaPlayer.pause();
                    playButton.setText("Play");
                } else {
                    mediaPlayer.play();
                    playButton.setText("Pause");
                }
            }
        });

        // Handle crop button
        cropButton.setOnAction(e -> {
            if (mediaPlayer != null) {
                showError("Not implemented", "Crop functionality is not yet implemented");
            } else {
                showError("No video", "Please load a video first");
            }
        });

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Video Cropper");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Cleanup on window close
        primaryStage.setOnCloseRequest(e -> {
            if (mediaPlayer != null) {
                mediaPlayer.dispose();
            }
            Platform.exit();
        });
    }

    private void showError(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}