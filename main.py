from flask import Flask, render_template, request

app = Flask(__name__)

study_sessions = []

@app.route('/')
def index():
    return render_template('index.html', study_sessions=study_sessions)

@app.route('/add', methods=['POST'])
def add():
    subject = request.form['subject']
    duration = request.form['duration']
    goal = request.form['goal']
    study_sessions.append({
        'subject': subject,
        'duration': duration,
        'goal': goal
    })
    return render_template('index.html', study_sessions=study_sessions)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)
