package ai.ilikeplaces.logic.validators.unit;

import ai.ilikeplaces.doc.License;
import ai.ilikeplaces.util.RefObj;
import net.sf.oval.configuration.annotation.IsInvariant;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: <a href="http://www.ilikeplaces.com"> http://www.ilikeplaces.com </a>
 * Date: Jan 22, 2010
 * Time: 2:16:43 AM
 */

@License(content = "This code is licensed under GNU AFFERO GENERAL PUBLIC LICENSE Version 3")
public class Password extends RefObj<String> {

    public Password() {
    }

    public Password(final String password) {
        obj = password;
    }

    @IsInvariant
    @NotNull
    @Length(min = 8, max = 255, message = "Sorry! Password is not between 8 and 255 characters long.")
    @NotBlank(message = "Sorry! Password cannot be blank.")
    @Override
    final public String getObj() {
        return obj;
    }


}