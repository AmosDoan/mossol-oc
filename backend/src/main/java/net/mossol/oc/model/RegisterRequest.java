package net.mossol.oc.model;

import lombok.Data;

@Data
public class RegisterRequest {
    private String userId;
    private String password;
}
