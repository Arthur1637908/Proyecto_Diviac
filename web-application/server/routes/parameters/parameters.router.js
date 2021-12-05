const express = require('express');
const router = express.Router();
const { getTP01 } = require('./parameters.data');
const delayTime = 0;

/* =========== GET PARAMETERS ============ */
router.get('/parameter-management/v1/parameters', (req, res) => {
    let status = 200;
    data = getTP01;
    console.log(data);
    res.status(status).send(data);
});

module.exports = router;