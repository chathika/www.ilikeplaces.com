package ai.ilikeplaces.logic.crud.unit;

import ai.ilikeplaces.doc.License;
import ai.ilikeplaces.entities.PublicPhoto;

import javax.ejb.Local;

/**
 *
 * @author Ravindranath Akila
 */

// @License(content = "This code is licensed under GNU AFFERO GENERAL PUBLIC LICENSE Version 3")
@License(content = "This code is licensed under GNU AFFERO GENERAL PUBLIC LICENSE Version 3")
@Local
public interface CPublicPhotoLocal {

    public PublicPhoto doNTxCPublicPhotoLocal(String humanId, long locationId, PublicPhoto publicPhoto );
}