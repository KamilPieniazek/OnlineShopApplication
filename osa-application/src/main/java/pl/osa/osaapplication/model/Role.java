package pl.osa.osaapplication.model;

import java.util.Arrays;
import java.util.List;

public enum Role {
    USER,
    ADMIN;

    public static List<Role> allTypes(){
        return Arrays.asList(Role.values()); }
}
