package pe.com.gob.diviac.business.police.adapter.output.postgres;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.IdentityDocumentEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.IdentityDocumentJpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.ParameterJpaRepository;
import pe.com.gob.diviac.business.police.domain.port.output.IdentityDocumentPort;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.util.constants.ErrorConstants;
import pe.com.gob.diviac.business.police.util.exception.DiviacStatusException;

@Slf4j
@Builder
@RequiredArgsConstructor
public class IdentityDocumentApiAdapter implements IdentityDocumentPort {

    private final IdentityDocumentJpaRepository identityDocumentJpaRepository;
    private final ParameterJpaRepository parameterJpaRepository;
    private final Function<Parameter, ParameterEntity> parameterEntityConverter;
    private final Function<IdentityDocumentEntity, IdentityDocument> identityDocumentConverter;
    private final Function<IdentityDocument, IdentityDocumentEntity> identityDocumentEntityConverter;

    @Override
    public IdentityDocument saveIdentityDocument(IdentityDocument identityDocumentToSave) {
        IdentityDocumentEntity identityDocumentEntityToSave;
        IdentityDocumentEntity identityDocumentEntity;

        log.info("Starting IdentityDocumentApiAdapter.saveIdentityDocument");
        this.validateIdentityDocumentDuplicity(identityDocumentToSave);
        this.validateUniqueIdentityDocument(identityDocumentToSave);
        identityDocumentEntityToSave = identityDocumentEntityConverter.apply(identityDocumentToSave);
        identityDocumentEntity = identityDocumentJpaRepository.save(identityDocumentEntityToSave);
        IdentityDocument identityDocumentResponse = identityDocumentConverter.apply(identityDocumentEntity);
        log.info("Finish IdentityDocumentApiAdapter.saveIdentityDocument successfully");

        return identityDocumentResponse;
    }

    @Override
    public IdentityDocument updateIdentityDocument(IdentityDocument identityDocumentToUpdate) {
        IdentityDocumentEntity identityDocumentEntityFound;
        IdentityDocumentEntity identityDocumentEntityUpdated;
        IdentityDocument identityDocument;

        log.info("Starting IdentityDocumentApiAdapter.updateIdentityDocument");
        this.validateIdentityDocumentDuplicity(identityDocumentToUpdate);
        this.validateUniqueIdentityDocument(identityDocumentToUpdate);
        identityDocumentEntityFound = this.obtainIdentityDocumentIfExists(identityDocumentToUpdate.getId());
        this.changeFieldsValuesToUpdateIdentityDocument(identityDocumentToUpdate, identityDocumentEntityFound);
        identityDocumentEntityUpdated = identityDocumentJpaRepository.save(identityDocumentEntityFound);
        identityDocument = identityDocumentConverter.apply(identityDocumentEntityUpdated);
        log.info("Finish IdentityDocumentApiAdapter.updateIdentityDocument successfully");

        return identityDocument;
    }

    @Override
    public List<IdentityDocument> findIdentityDocumentsByPoliceId(UUID id) {
        Optional<List<IdentityDocumentEntity>> optionalIdentityDocumentEntityList;
        List<IdentityDocument> identityDocumentList = new ArrayList<>();

        log.info("Starting IdentityDocumentApiAdapter.findIdentityDocumentsByPoliceId");
        optionalIdentityDocumentEntityList = identityDocumentJpaRepository.findByPoliceIdAndState(id, Boolean.TRUE);

        if (optionalIdentityDocumentEntityList.isPresent()) {
            identityDocumentList = optionalIdentityDocumentEntityList
                    .get()
                    .stream()
                    .map(identityDocumentConverter)
                    .collect(Collectors.toList());
        }

        log.info("Finish IdentityDocumentApiAdapter.findIdentityDocumentsByPoliceId successfully");

        return identityDocumentList;
    }

    @Override
    public void deleteIdentityDocumentByPoliceId(UUID id) {
        Optional<List<IdentityDocumentEntity>> optionalIdentityDocumentEntityList;
        List<IdentityDocumentEntity> identityDocumentEntityList;

        log.info("Starting IdentityDocumentApiAdapter.deleteIdentityDocumentByPoliceId");
        optionalIdentityDocumentEntityList = identityDocumentJpaRepository.findByPoliceIdAndState(id, Boolean.TRUE);

        if (optionalIdentityDocumentEntityList.isPresent()) {
            identityDocumentEntityList = optionalIdentityDocumentEntityList.get();
            identityDocumentEntityList.forEach(identityDocumentEntity -> identityDocumentEntity.setState(Boolean.FALSE));
            identityDocumentJpaRepository.saveAll(identityDocumentEntityList);
        }

        log.info("Finish IdentityDocumentApiAdapter.deleteIdentityDocumentByPoliceId successfully");
    }

    @Override
    public void deleteIdentityDocumentById(Long id) {
        IdentityDocumentEntity identityDocumentEntityFound;

        log.info("Starting IdentityDocumentApiAdapter.deleteIdentityDocumentById");
        identityDocumentEntityFound = this.obtainIdentityDocumentIfExists(id);
        this.changeFieldsValuesToDeleteIdentityDocument(identityDocumentEntityFound);
        identityDocumentJpaRepository.save(identityDocumentEntityFound);
        log.info("Finish IdentityDocumentApiAdapter.deleteIdentityDocumentById successfully");
    }

    private IdentityDocumentEntity obtainIdentityDocumentIfExists(Long id) {
        Optional<IdentityDocumentEntity> optionalIdentityDocumentEntity;

        optionalIdentityDocumentEntity = identityDocumentJpaRepository.findByIdAndState(id, Boolean.TRUE);

        if (!optionalIdentityDocumentEntity.isPresent()) {
            throw new DiviacStatusException(HttpStatus.NOT_FOUND,
                    ErrorConstants.ERROR_IDENTITY_DOCUMENT_NOT_FOUND_CODE,
                    ErrorConstants.ERROR_IDENTITY_DOCUMENT_NOT_FOUND_DESCRIPTION);
        }

        return optionalIdentityDocumentEntity.get();
    }

    private void validateIdentityDocumentDuplicity(IdentityDocument identityDocument) {
        Optional<IdentityDocumentEntity> optionalIdentityDocumentEntity;

        optionalIdentityDocumentEntity = identityDocumentJpaRepository.findByPoliceIdAndDocumentTypeIdAndState(
                identityDocument.getPolice().getId(), identityDocument.getDocumentType().getId(), Boolean.TRUE);

        if (optionalIdentityDocumentEntity.isPresent()) {
            throw new DiviacStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    ErrorConstants.ERROR_IDENTITY_DOCUMENT_TYPE_DUPLICITY_CODE,
                    ErrorConstants.ERROR_IDENTITY_DOCUMENT_TYPE_DUPLICITY_DESCRIPTION);
        }
    }

    private void validateUniqueIdentityDocument(IdentityDocument identityDocument) {
        Optional<IdentityDocumentEntity> optionalIdentityDocumentEntity;
        Optional<IdentityDocumentEntity> optionalIdentityDocumentEntityByDocumentNumber;

        optionalIdentityDocumentEntity = identityDocumentJpaRepository.findByDocumentTypeIdAndDocumentNumberAndState(
                identityDocument.getDocumentType().getId(), identityDocument.getDocumentNumber(), Boolean.TRUE);

        optionalIdentityDocumentEntityByDocumentNumber = identityDocumentJpaRepository.findByDocumentNumberAndState(
                identityDocument.getDocumentNumber(), Boolean.TRUE);

        if (optionalIdentityDocumentEntity.isPresent() || optionalIdentityDocumentEntityByDocumentNumber.isPresent()) {
            throw new DiviacStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    ErrorConstants.ERROR_IDENTITY_DOCUMENT_NUMBER_DUPLICITY_CODE,
                    ErrorConstants.ERROR_IDENTITY_DOCUMENT_NUMBER_DUPLICITY_DESCRIPTION);
        }
    }

    private void changeFieldsValuesToUpdateIdentityDocument(IdentityDocument identityDocument,
                                                            IdentityDocumentEntity identityDocumentEntityFound) {
        identityDocumentEntityFound.setDocumentType(parameterEntityConverter.apply(identityDocument.getDocumentType()));
        identityDocumentEntityFound.setDocumentNumber(identityDocument.getDocumentNumber());

        //TODO: Implement audit logic
        identityDocumentEntityFound.setUpdateUserId(String.valueOf(UUID.randomUUID()));
        identityDocumentEntityFound.setUpdateUserRoleId(1);
    }

    private void changeFieldsValuesToDeleteIdentityDocument(IdentityDocumentEntity identityDocumentEntityFound) {
        identityDocumentEntityFound.setState(Boolean.FALSE);

        //TODO: Implement audit logic
        identityDocumentEntityFound.setUpdateUserId(String.valueOf(UUID.randomUUID()));
        identityDocumentEntityFound.setUpdateUserRoleId(1);
    }

}
