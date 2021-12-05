const express = require('express');
const ubigeoRouter = require('./routes/ubigeo/ubigeo.router');
const divisionRouter = require('./routes/division/division.router');
const policeRouter = require('./routes/police/police.router');
const parametersRouter = require('./routes/parameters/parameters.router');

var cors = require('cors');
var app = express();

const prefixChannel = '/channel';
const prefixBusiness = '/business';
const PORT = 6969;

// Open CORS
app.use(cors());

// Parse request body
app.use(express.json());

// Mount routers
app.use(
  prefixChannel,
  ubigeoRouter,
  parametersRouter
);

app.use(
  prefixBusiness,
  divisionRouter,
  policeRouter,
  parametersRouter);

app.get('/', (req, res) => {
  res.send('It works!');
});

// Catch-all 404
// app.use(function (req, res, next) {
//   const err = new Error('Not Found');
//   err.status = 404;
//   next(err);
// });

// Listen for incoming connections
app.listen(PORT, function () {
  console.info(`Server listening ` + PORT);
}).on('error', err => {
  console.error(err);
});
