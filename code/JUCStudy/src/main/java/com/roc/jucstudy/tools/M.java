package com.roc.jucstudy.tools;

public class M {
    @Override
    protected void finalize() throws Throwable
    {
        System.out.println("finalize");
    }
}
