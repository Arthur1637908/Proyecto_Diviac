package pe.com.gob.diviac.business.police.adapter.output.postgres.specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Builder;

import org.springframework.data.jpa.domain.Specification;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.IdentityDocumentEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;
import pe.com.gob.diviac.business.police.entity.request.PolicePagedListRequest;
import pe.com.gob.diviac.business.police.util.StringUtils;

@Builder
public class PoliceEntitySpecification {

    public Specification<PoliceEntity> getSpecificationForAllPolices(PolicePagedListRequest policePagedListRequest) {
        return (root, query, criteriaBuilder) -> {
            ListJoin<PoliceEntity, IdentityDocumentEntity> policeJoinIdentityDocument;

            policeJoinIdentityDocument = root.joinList("identityDocumentList", JoinType.LEFT);
            query.distinct(Boolean.TRUE);

            return Specification
                    .where(this.getPoliceEnabled())
                    .and(this.getPoliceByCip(policePagedListRequest.getCip()))
                    .and(this.getPoliceByName(policePagedListRequest.getName()))
                    .and(this.getPoliceByDocumentType(policePagedListRequest.getDocumentTypeId(), policeJoinIdentityDocument))
                    .and(this.getPoliceByDocumentNumber(policePagedListRequest.getDocumentNumber(), policeJoinIdentityDocument))
                    .toPredicate(root, query, criteriaBuilder);
        };
    }

    private Specification<PoliceEntity> getPoliceEnabled() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("state"), Boolean.TRUE);
    }

    private Specification<PoliceEntity> getPoliceByCip(String cip) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(cip)) {
                return  null;
            }

            return criteriaBuilder.equal(root.get("cip"), cip);
        };
    }

    private Specification<PoliceEntity> getPoliceByName(String name) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (Objects.isNull(name)) {
                return  null;
            }

            predicateList.add(criteriaBuilder.like(root.get("firstName"),
                    StringUtils.PERCENT.concat(name).concat(StringUtils.PERCENT)));
            predicateList.add(criteriaBuilder.like(root.get("secondName"),
                    StringUtils.PERCENT.concat(name).concat(StringUtils.PERCENT)));
            predicateList.add(criteriaBuilder.like(root.get("lastName"),
                    StringUtils.PERCENT.concat(name).concat(StringUtils.PERCENT)));
            predicateList.add(criteriaBuilder.like(root.get("secondLastName"),
                    StringUtils.PERCENT.concat(name).concat(StringUtils.PERCENT)));

            return criteriaBuilder.or(predicateList.toArray(new Predicate[0]));
        };
    }

    private Specification<PoliceEntity> getPoliceByDocumentType(
            Integer documentTypeId,
            ListJoin<PoliceEntity, IdentityDocumentEntity> policeJoinIdentityDocument) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            Join<IdentityDocumentEntity, ParameterEntity> identityDocumentJoinParameter;

            if (Objects.isNull(documentTypeId)) {
                return null;
            }

            identityDocumentJoinParameter = policeJoinIdentityDocument.join("documentType", JoinType.INNER);

            predicateList.add(criteriaBuilder.equal(identityDocumentJoinParameter.get("id"), documentTypeId));
            predicateList.add(criteriaBuilder.equal(identityDocumentJoinParameter.get("state"), Boolean.TRUE));
            predicateList.add(criteriaBuilder.equal(policeJoinIdentityDocument.get("state"), Boolean.TRUE));

            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };
    }

    private Specification<PoliceEntity> getPoliceByDocumentNumber(
            String documentNumber,
            ListJoin<PoliceEntity, IdentityDocumentEntity> policeJoinIdentityDocument) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(documentNumber)) {
                return null;
            }

            return criteriaBuilder.equal(policeJoinIdentityDocument.get("documentNumber"), documentNumber);
        };
    }
}
