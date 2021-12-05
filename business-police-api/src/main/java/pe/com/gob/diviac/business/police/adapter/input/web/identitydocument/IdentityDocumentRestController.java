package pe.com.gob.diviac.business.police.adapter.input.web.identitydocument;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.converter.update.request.UpdateIdentityDocumentRestRequestConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.list.response.IdentityDocumentItemRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.save.request.SaveIdentityDocumentRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.save.response.SaveIdentityDocumentRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.update.request.UpdateIdentityDocumentRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.update.response.UpdateIdentityDocumentRestResponse;
import pe.com.gob.diviac.business.police.application.errorhandling.ErrorInformation;
import pe.com.gob.diviac.business.police.domain.port.input.IdentityDocumentUseCase;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/polices/identity-documents")
@Tag(name = "Identity Document", description = "Identity Document Controller")
public class IdentityDocumentRestController {

    private final IdentityDocumentUseCase identityDocumentUseCase;
    private final Function<IdentityDocument, IdentityDocumentItemRestResponse> identityDocumentItemRestResponseConverter;
    private final Function<SaveIdentityDocumentRestRequest, IdentityDocument> saveIdentityDocumentRestRequestConverter;
    private final Function<IdentityDocument, SaveIdentityDocumentRestResponse> saveIdentityDocumentRestResponseConverter;
    private final Function<UpdateIdentityDocumentRestRequestConverter.Wrapper, IdentityDocument>
            updateIdentityDocumentRestRequestConverter;
    private final Function<IdentityDocument, UpdateIdentityDocumentRestResponse> updateIdentityDocumentRestResponseConverter;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get identity documents", description = "Get police identity documents")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = IdentityDocumentItemRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public List<IdentityDocumentItemRestResponse> getIdentityDocumentsByPoliceId(@RequestParam UUID policeId) {
        List<IdentityDocumentItemRestResponse> identityDocumentRestResponseList;

        log.info("Starting IdentityDocumentRestController.getIdentityDocumentsByPoliceId");
        identityDocumentRestResponseList = identityDocumentUseCase.findIdentityDocumentsByPoliceId(policeId)
                .stream()
                .map(identityDocumentItemRestResponseConverter)
                .collect(Collectors.toList());
        log.info("Finish IdentityDocumentRestController.getIdentityDocumentsByPoliceId successfully");

        return identityDocumentRestResponseList;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save identity document", description = "Save police identity document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = SaveIdentityDocumentRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public SaveIdentityDocumentRestResponse saveIdentityDocument(
            @Valid @RequestBody SaveIdentityDocumentRestRequest saveIdentityDocumentRestRequest) {
        IdentityDocument identityDocumentToSave;
        IdentityDocument identityDocument;
        SaveIdentityDocumentRestResponse saveIdentityDocumentRestResponse;

        log.info("Starting IdentityDocumentRestController.saveIdentityDocument");
        identityDocumentToSave = saveIdentityDocumentRestRequestConverter.apply(saveIdentityDocumentRestRequest);
        identityDocument = identityDocumentUseCase.saveIdentityDocument(identityDocumentToSave);
        saveIdentityDocumentRestResponse = saveIdentityDocumentRestResponseConverter.apply(identityDocument);
        log.info("Finish IdentityDocumentRestController.saveIdentityDocument successfully");

        return saveIdentityDocumentRestResponse;
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update identity document", description = "Update police identity document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = UpdateIdentityDocumentRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public UpdateIdentityDocumentRestResponse updateIdentityDocument(
            @PathVariable Long id,
            @Valid @RequestBody UpdateIdentityDocumentRestRequest updateIdentityDocumentRestRequest) {
        IdentityDocument identityDocumentToUpdate;
        IdentityDocument identityDocument;
        UpdateIdentityDocumentRestResponse updateIdentityDocumentRestResponse;

        log.info("Starting IdentityDocumentRestController.updateIdentityDocument");
        identityDocumentToUpdate = updateIdentityDocumentRestRequestConverter.apply(
                UpdateIdentityDocumentRestRequestConverter.Wrapper.builder()
                        .id(id).updateIdentityDocumentRestRequest(updateIdentityDocumentRestRequest)
                        .build());
        identityDocument = identityDocumentUseCase.updateIdentityDocument(identityDocumentToUpdate);
        updateIdentityDocumentRestResponse = updateIdentityDocumentRestResponseConverter.apply(identityDocument);
        log.info("Finish IdentityDocumentRestController.updateIdentityDocument successfully");

        return updateIdentityDocumentRestResponse;
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete identity document", description = "Delete police identity document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok"),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public void deleteIdentityDocument(@PathVariable Long id) {
        log.info("Starting IdentityDocumentRestController.deleteIdentityDocument");
        identityDocumentUseCase.deleteIdentityDocument(id);
        log.info("Finish IdentityDocumentRestController.deleteIdentityDocument successfully");
    }

}
