import { AbstractControl, FormControl } from '@angular/forms';

const validateLandlineOrMobilePhone = (c: AbstractControl) => {
    const phoneNumber = c.value;
    const validation = (
        (
            (phoneNumber.length === 7 || phoneNumber.length === 9) &&
            (/^[0-9]+$/.test(phoneNumber))
        ) ||
        phoneNumber == '' ||
        phoneNumber == null
    );

    return validation ? null : {
        validateLandlineOrMobilePhone: {
            valid: false
        }
    };
}

const validateOnlyNumbers = (c: AbstractControl) => {
    const value = c.value;
    const validation = (
        /^[0-9]*$/.test(value) ||
        value == '' ||
        value == null
    );

    return validation ? null : {
        validateOnlyNumbers: {
            valid: false
        }
    };
}

const validateGobCustomEmail = (c: AbstractControl) => {
    const email = c.value;
    const validation = (
        /policia.gob.pe\s*$/.test(email) ||
        /POLICIA.GOB.PE\s*$/.test(email) ||
        /hotmail.com\s*$/.test(email) ||
        /HOTMAIL.COM\s*$/.test(email) ||
        /gmail.com\s*$/.test(email) ||
        /GMAIL.COM\s*$/.test(email) ||
        email == '' ||
        email == null
    );

    return validation ? null : {
        validateGobCustomEmail: {
            valid: false
        }
    };
}

const validateAlphabetical = (c: AbstractControl) => {
    const value = c.value;
    const validation = (
        /^[ñA-Za-z-\u00C0-\u00FF _]*[ñA-Za-z-\u00C0-\u00FF][ñA-Za-z-\u00C0-\u00FF _]*$/g.test(value) ||
        value == '' ||
        value == null
    );

    return validation ? null : {
        validateAlphabetical: {
            valid: false
        }
    };
}

const validateAlphabeticalWithoutSpace = (c: AbstractControl) => {
    const value = c.value;
    const validation = (
        /^[ñA-Za-z\u00C0-\u00FF_]*[ñA-Za-z\u00C0-\u00FF][ñA-Za-z\u00C0-\u00FF_]*$/g.test(value) ||
        value == '' ||
        value == null
    );

    return validation ? null : {
        validateAlphabeticalWithoutSpace: {
            valid: false
        }
    };
}

const validateAlphanumericWithoutSpace = (c: AbstractControl) => {
    const value = c.value;
    const validation = (
        /^[ñA-Za-z0-9\u00C0-\u00FF_]*[ñA-Za-z0-9\u00C0-\u00FF][ñA-Za-z0-9\u00C0-\u00FF_]*$/g.test(value) ||
        value == '' ||
        value == null
    );

    return validation ? null : {
        validateAlphanumericWithoutSpace: {
            valid: false
        }
    };
}

const validateAlphanumeric = (additional: string) => {
    return (c: FormControl) => {

        const value = c.value;
        const re = new RegExp(`^[ñA-Za-z${additional}/0-9\u00C0-\u00FF _]*[ñA-Za-z${additional}0-9\u00C0-\u00FF][ñA-Za-z${additional}0-9\u00C0-\u00FF _]*$`, 'g');
        const validation = (
            value.match(re) ||
            value == '' ||
            value == null
        );

        return validation ? null : {
            validateAlphanumeric: {
                valid: false
            }
        };
    };
}

export const CustomFormValidations = {
    validateLandlineOrMobilePhone,
    validateGobCustomEmail,
    validateAlphabetical,
    validateAlphanumeric,
    validateOnlyNumbers,
    validateAlphabeticalWithoutSpace,
    validateAlphanumericWithoutSpace
}