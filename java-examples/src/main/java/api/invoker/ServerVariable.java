package api.invoker;

import java.util.HashSet;

/**
 * Representing a Server Variable for server URL template substitution.
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-16T18:58:01.210254-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class ServerVariable {
    public String description;
    public String defaultValue;
    public HashSet<String> enumValues = null;

    /**
     * @param description A description for the server variable.
     * @param defaultValue The default value to use for substitution.
     * @param enumValues An enumeration of string values to be used if the substitution options are from a limited set.
     */
    public ServerVariable(String description, String defaultValue, HashSet<String> enumValues) {
        this.description = description;
        this.defaultValue = defaultValue;
        this.enumValues = enumValues;
    }
}
