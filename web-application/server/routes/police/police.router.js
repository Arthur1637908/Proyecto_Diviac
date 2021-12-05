const express = require('express');
const router = express.Router();
const { getPolices, createPolice, policeGeneralInformationDetail, updatePolice, policeSituations, policeIdentityDocuments } = require('./police.data');
const delayTime = 0;

/* =========== GET POLICES ============ */
router.get('/police-management/v1/polices', (req, res) => {
    let status = 200;
    data = getPolices;
    console.log(data);
    res.status(status).send(data)
});

/* =========== CREATE POLICE ============ */
router.post('/police-management/v1/polices/general-information', (req, res) => {
    let status = 200;
    data = createPolice;
    console.log(data);
    res.status(status).send(data)
});

/* =========== GET GENERAL INFORMATION POLICE BY ID ============ */
router.get('/police-management/v1/polices/general-information/:id', (req, res) => {
    let status = 200;
    data = policeGeneralInformationDetail;
    console.log(data);
    res.status(status).send(data)
});

/* =========== UPDATE POLICE BY ID ============ */
router.put('/police-management/v1/polices/general-information/:id', (req, res) => {
    let status = 200;
    data = updatePolice;
    console.log(data);
    res.status(status).send(data)
});


/* =========== DELETE POLICE BY ID ============ */
router.delete('/police-management/v1/polices/:id', (req, res) => {
    let status = 200;
    data = {};
    console.log(data);
    res.status(status).send(data)
});

/* =========== GET SITUATIONS POLICE BY ID ============ */
router.get('/police-management/v1/polices/situations', (req, res) => {
    let status = 200;
    data = policeSituations;
    console.log(data);
    res.status(status).send(data)
});

/* =========== GET IDENTITY DOCUMENTS POLICE BY ID ============ */
router.get('/police-management/v1/polices/identity-documents', (req, res) => {
    let status = 200;
    data = policeIdentityDocuments;
    console.log(data);
    res.status(status).send(data)
});

module.exports = router;