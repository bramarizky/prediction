from flask import Flask, request, jsonify
import numpy as np
import joblib

app = Flask(__name__)

# Load your machine learning model
model = joblib.load('model.pkl')

@app.route('/predict', methods=['POST'])
def predict():
    try:
        # Menerima data dalam format JSON
        data = request.get_json()

        # Validasi data input dari request
        expected_fields = [
            'gender', 'age', 'occupation', 'sleep', 'bmi',
            'heartRate', 'steps', 'systolic'
        ]
        if not all(field in data for field in expected_fields):
            return jsonify({"error": "Missing input fields"}), 400

        # Ambil data dari request
        gender = int(data['gender'])
        age = int(data['age'])
        occupation = int(data['occupation'])
        sleep = int(data['sleep'])
        bmi = int(data['bmi'])
        heartRate = int(data['heartRate'])
        steps = int(data['steps'])
        systolic = int(data['systolic'])

        # Buat array fitur dan lakukan prediksi
        features = np.array([gender, age, occupation, sleep, bmi, heartRate, steps, systolic]).reshape(1, -1)

        # Prediksi menggunakan model
        prediction = model.predict(features)

        # Kirim hasil prediksi dalam format JSON
        return jsonify(int(prediction[0]))

    except Exception as e:
        return jsonify({"error": str(e)}), 500


if __name__ == '__main__':
    app.run(debug=True, host='localhost', port=5000)
