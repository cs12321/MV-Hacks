const express = require('express')
const app = express()
const port = 3000

app.get('/lyrics', function(req, res){
var trackname = req.query.trackname;
var artistname = req.query.artistname;


var exec = require('child_process').exec, child;
child = exec('java -jar ~/Desktop/songproject.jar "' + trackname + '" "' + artistname + '"', function(error, stdout, stderr){
// console.log('stdout:' + stdout);
// console.log('stderr:' + stderr);
res.setHeader('Content-Type', 'application/json');
res.send({lyrics: stdout});

});
});

app.get('/', function(req, res){
res.sendFile('static/mainsite.html', {root: __dirname})




/*
var trackname = req.query.trackname;
var artistname = req.query.artistname;
var exec = require('child_process').exec, child;
child = exec('java -jar ~/Desktop/songproject.jar "' + trackname + '" "' + artistname + '"', function(error, stdout, stderr){
	console.log('stdout:' + stdout);
	console.log('stderr:' + stderr);

});
*/
});

app.get('/song', function(req, res){
	var songname = req.query.songname;
	var exec = require('child_process').exec, child;
child = exec('java -jar ~/Desktop/songproject.jar "' + songname + '"', function(error, stdout, stderr){
// console.log('stdout:' + stdout);
// console.log('stderr:' + stderr);
res.setHeader('Content-Type', 'application/json');
res.send({lyrics: stdout});

});
});

app.use(express.static('static'))

app.listen(port, () => console.log(`Example app listening on port ${port}!`))

// var exec = require('child_process').exec, child;
// child = exec('~/Desktop/java -jar songproject.jar', function(error, stdout, stderr){
// 	console.log('stdout:' + stdout);
// 	console.log('stderr:' + stderr);
// });
