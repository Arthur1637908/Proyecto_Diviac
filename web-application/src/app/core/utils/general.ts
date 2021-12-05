const getExtensionFile = (fileName: string) => {
    return fileName.split('.').pop()
}

export const GeneralUtils = {
    getExtensionFile
}