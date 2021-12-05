module.exports = {
  getDivisions: {
    "page": {
      "totalNumberOfItems": 128,
      "numberOfPages": 10
    },
    "divisions": [{
        "id": "a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11",
        "code": "DIV01",
        "acronym": "DIVLO",
        "name": "División de Los Olivos",
        "description": "División con más de 10 años...",
        "address": {
          "id": 1,
          "name": "Los Tulipanes",
          "number": "424",
          "typeId": 1,
          "districtId": 1,
          "provinceId": 1,
          "departmentId": 1
        },
        "contact": {
          "email": "example@abc.com",
          "phoneNumber": "55555",
          "annexNumber": "555"
        }
      },
      {
        "id": "a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12",
        "code": "DIV02",
        "acronym": "DIVPL",
        "name": "División de San MArtin de Porres",
        "description": "División con más de 10 años...",
        "address": {
          "id": 1,
          "name": "Los Tulipanes",
          "number": "424",
          "typeId": 1,
          "districtId": 1,
          "provinceId": 1,
          "departmentId": 1
        },
        "contact": {
          "email": "example@abc.com",
          "phoneNumber": "55555",
          "annexNumber": "555"
        }
      }
    ]
  },
  createDivision: {},
  updateDivision: {
    "id": "a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11",
    "code": "DIV01",
    "acronym": "DIVLO",
    "name": "División de Los Olivos",
    "description": "División con más de 10 años...",
    "address": {
      "id": 1,
      "name": "Los Tulipanes",
      "number": "424",
      "typeId": 1,
      "districtId": 1,
      "provinceId": 1,
      "departmentId": 1
    },
    "contact": {
      "email": "example@abc.com",
      "phoneNumber": "55555",
      "annexNumber": "555"
    }
  },
  divisionDetail: {
    "id": "4cc80a99-7fb6-4618-b1a0-f0d7a9328118",
    "code": "DV001",
    "acronym": "SGL",
    "name": "DIVISION NAME",
    "description": "DIVISION DESCRIPTION",
    "address": {
      "id": 1,
      "name": "JR. PUNO",
      "number": "123",
      "type": {
        "id": 1,
        "name": "AVENIDA"
      },
      "district": {
        "id": 1,
        "name": "LOS OLIVOS"
      },
      "province": {
        "id": 1,
        "name": "LIMA"
      },
      "department": {
        "id": 1,
        "name": "LIMA"
      }
    },
    "contact": {
      "email": "EMAIL@POLICIA.GOB.PE",
      "phoneNumber": "5522113",
      "annexNumber": "3212"
    }
  }
}
