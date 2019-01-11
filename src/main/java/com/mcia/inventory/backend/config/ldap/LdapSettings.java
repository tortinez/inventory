package com.mcia.inventory.backend.config.ldap;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ConfigurationProperties(prefix = "ldap")
public class LdapSettings {

    @NotNull
    @NotEmpty(message = "LDAP url property is not valid")
    private String url;

    @NotNull
    @NotEmpty(message = "LDAP basedn property is not valid")
    private String basedn;


}
