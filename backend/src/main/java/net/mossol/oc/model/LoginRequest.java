package net.mossol.oc.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String userId;
    private String password;
}