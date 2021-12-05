package pe.com.gob.diviac.business.police.domain.port.input;

import java.util.UUID;

import pe.com.gob.diviac.business.police.entity.Police;

public interface GeneralInformationUseCase {

    Police getPoliceGeneralInformationDetail(UUID policeId);

    Police savePoliceGeneralInformation(Police policeToSave);

    Police updateGeneralInformation(Police policeToUpdate);
}
