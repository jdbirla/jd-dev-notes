package com.jd.interviewprep.corejava;

import java.util.Objects;

/**
 * Created by jd birla on 02-02-2023 at 07:02
 */
public class EqualsMethodOverrideExample {
    private int id;
    private String firstName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsMethodOverrideExample client = (EqualsMethodOverrideExample) o;
        return id == client.id && Objects.equals(firstName, client.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName);
    }
}
