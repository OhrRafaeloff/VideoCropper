# VideoCropper 🎞️✂️

VideoCropper is a JavaFX-based desktop application that lets you **crop and trim videos visually** using a simple GUI. Built with Java and powered by FFmpeg, this tool makes it easy to extract exactly what you need from any video clip.

---

## ✨ Features

- 🖱️ Interactive cropping area (draw over video)
- ⏱️ Set custom start and end times for trimming
- 📤 Export cropped & trimmed videos using FFmpeg
- 🖥️ JavaFX-based user interface
- ⚙️ Cross-platform (Windows, macOS, Linux)

---

## 🛠️ Tech Stack

- Java 17+
- JavaFX
- FFmpeg (CLI)
- Gradle

---

## 📦 Installation

### 1. Clone the repo

```bash
git clone https://github.com/OhrRafaeloff/VideoCropper.git
cd VideoCropper
```

### 2. Make sure you have:
- ✅ Java 17+ installed
- ✅ FFmpeg installed and added to system PATH
- ✅ Gradle (optional — can use Gradle Wrapper)

### 3. Run the app

```bash
./gradlew run
```

> Or open the project in IntelliJ IDEA and run `Main.java`.

---

## 🖼️ Screenshot

![screenshot](docs/screenshot.png) <!-- (Optional: Add a screenshot if you have one) -->

---

## 🧪 Usage

1. Load a video file
2. Select crop area using mouse
3. Set start and end timestamps
4. Export using "Save" button

Output will be saved in the same folder as the source video (or a specified output directory).

---

## 📂 Project Structure

```
VideoCropper/
├── src/main/java/com/videocropper/
│   └── Main.java
├── build.gradle
├── settings.gradle
└── .gitignore
```

---

## 📝 License

This project is licensed under the **MIT License** — see [LICENSE](LICENSE) for details.

---

## 🙋‍♂️ Author

**Ohr Rafaeloff**  
📫 [@OhrRafaeloff on GitHub](https://github.com/OhrRafaeloff)

---

## ⭐️ Contribute

Pull requests are welcome! If you find a bug or want to suggest a feature, open an issue or submit a PR.
