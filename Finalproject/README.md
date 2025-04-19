# MNIST Digit Recognition - JavaFX + TensorFlow Lite

This project is a handwritten digit recognizer that allows users to draw numbers (0–9) via a JavaFX GUI. The image is sent to a local Python server that performs inference using a pre-trained and converted TensorFlow Lite (TFLite) model.

## 🚀 Project Execution Guide (For Instructor / TA)

### 🔧 Prerequisites
- Java 17+
- Maven
- Internet access to clone the repository
- A Unix-based system (macOS/Linux) or Git Bash (if on Windows)

### 📦 Step-by-Step Instructions

#### ✅ 1. Clone the Project

```
mkdir ChenTingKuo
cd ChenTingKuo
git clone https://github.com/ctkuo2438/INFO5100_002304821_ChenTingKuo.git
cd INFO5100_002304821_ChenTingKuo/Finalproject/model
```
#### ✅ 2. Download the Python Inference Server (Required)

⚠️ GitHub does not allow files larger than 100MB.
Please manually download the TFLite server executable:
🔗 https://drive.google.com/file/d/1xvq_X0NxtxDpyRFEeoL05AlA6CV__moU/view?usp=drive_link

Then unzip it into the dist/ folder:
```
unzip predict_server.zip -d dist/
chmod +x dist/predict_server  # Optional: make it executable
```
You should now have:
```
Finalproject/model/dist/predict_server
```
#### ✅ 3. Run the Python TFLite Inference Server
```
cd dist
./predict_server
# Server should start at http://127.0.0.1:5050

```
#### ✅ 4. Open Another Terminal and Run the JavaFX GUI
```
cd ChenTingKuo/INFO5100_002304821_ChenTingKuo
mvn javafx:run
```
#### ✅ 5. Finish
- Press Ctrl + C in the server terminal to stop the inference server
- Close the Java GUI window


#### 👨‍💻 Author
- Name: Chen-Ting Kuo
- ID: 002304821
- Course: INFO 5100