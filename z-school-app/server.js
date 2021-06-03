const express = require('express');

// Constants
const PORT = 8080;
const HOST = '0.0.0.0';

// App
const app = express();

app.use(express.static(__dirname + "/dist/z-school-app"));

app.get("/*", function(req, res) {
  res.sendFile(path.join(__dirname + "/dist/z-school-app/index.html"));
});

app.listen(PORT, HOST);
console.log(`MyUdemyApp is running on http://${HOST}:${PORT}`);