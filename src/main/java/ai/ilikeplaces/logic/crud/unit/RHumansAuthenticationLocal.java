package ai.ilikeplaces.logic.crud.unit;

import ai.ilikeplaces.entities.HumansAuthentication;
import ai.scribble.License;

import javax.ejb.Local;

/**
 * @author Ravindranath Akila
 */

@License(content = "This code is licensed under GNU AFFERO GENERAL PUBLIC LICENSE Version 3")
@Local
public interface RHumansAuthenticationLocal {

    public HumansAuthentication doDirtyRHumansAuthentication(String humanId);
}
