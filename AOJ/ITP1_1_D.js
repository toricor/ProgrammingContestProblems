process.stdin.resume();
process.stdin.setEncoding('utf8');
process.stdin.on('data', function (chunk) {
    var line = chunk.toString().split('\n');
    var S = Number(line[0]);
    var h = Math.floor(S/3600);
    var m = Math.floor(S%3600/60);
    var s = S%60
    console.log(h + ":" + m + ":" + s);
});
