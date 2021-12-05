const express = require('express');
const router = express.Router();
const { getDivisions, createDivision, divisionDetail, updateDivision } = require('./division.data');
const delayTime = 0;

/* =========== GET DIVISIONS ============ */
router.get('/division-management/v1/divisions', (req, res) => {
    let status = 200;
    data = getDivisions;
    console.log(data);
    res.status(status).send(data)
});

/* =========== CREATE DIVISION ============ */
router.post('/division-management/v1/divisions', (req, res) => {
    let status = 200;
    data = createDivision;
    console.log(data);
    res.status(status).send(data)
});

/* =========== GET DIVISION BY ID ============ */
router.get('/division-management/v1/divisions/:id', (req, res) => {
    let status = 200;
    data = divisionDetail;
    console.log(data);
    res.status(status).send(data)
});

/* =========== UPDATE DIVISION BY ID ============ */
router.put('/division-management/v1/divisions/:id', (req, res) => {
    let status = 200;
    data = updateDivision;
    console.log(data);
    res.status(status).send(data)
});


/* =========== DELETE DIVISION BY ID ============ */
router.delete('/division-management/v1/divisions/:id', (req, res) => {
    let status = 200;
    data = {};
    console.log(data);
    res.status(status).send(data)
});

module.exports = router;