const express = require('express');
const router = express.Router();
const { getDepartments, getProvinces, getDistricts } = require('./ubigeo.data');
const delayTime = 0;

/* =========== GET DEPARTMENTS ============ */
router.get('/parameter-management/v1/ubigeos/departments', (req, res) => {
    let status = 200;
    data = getDepartments;
    console.log(data);
    res.status(status).send(data);
});

/* =========== GET PROVINCES ============ */
router.get('/parameter-management/v1/ubigeos/provinces', (req, res) => {
    let status = 200;
    data = getProvinces;
    console.log(data);
    res.status(status).send(data);
});

/* =========== GET DISTRICS ============ */
router.get('/parameter-management/v1/ubigeos/districts', (req, res) => {
    let status = 200;
    data = getDistricts;
    console.log(data);
    res.status(status).send(data);
});

module.exports = router;