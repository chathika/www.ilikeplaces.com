package ai.ilikeplaces.logic.verify.util;

import ai.ilikeplaces.doc.CONVENTION;

/**
 * Created by IntelliJ IDEA.
 * User: Ravindranath Akila
 * Date: Nov 18, 2009
 * Time: 6:12:52 PM
 */
@CONVENTION(convention = "IF YOU HAVE A STATIC ONLY CLASS, THEN SIMPLY DEFINE THIS METHOD AS STATIC WITH THE REST" +
        "OF THE SIGNATURE SAME. DURING VERIFICATION, IT WILL BE CALLED IF REGISTERED REGARDLESS OF WHETHER IT IMPLEMENTS" +
        "THIS INTEFACE OR NOT.")
public interface Verify {

    /**
     * Do your verification inside this method. Try to encapsulate all exceptions within the method and provide
     * humanly readable debug messages.
     * @return The Result Of Verification. e.g. Done, Error-Resource Down.
     */
    public String verify();
}