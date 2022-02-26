import flask
from flask import render_template
from flask import Response, request

app = flask.Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/help')
def help():
    return render_template('help.html')

@app.route('/live_feed')
def liveFeed():
    return render_template('video.html')

@app.route("/upload")
def upload():
    return render_template("image.html")

@app.route('/dictionary')
def openDictionary():
    return render_template('dictionary.html')

if __name__ == "__main__":
    app.run()
