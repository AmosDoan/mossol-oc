package net.mossol.oc.model;

import lombok.Data;

@Data
public class RegisterRequest {
    private String UserId;
    private String password;
}
