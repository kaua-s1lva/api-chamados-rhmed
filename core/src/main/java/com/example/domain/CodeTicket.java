package com.example.domain;

import java.util.Random;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

public class CodeTicket {
    private final char[] alphabet;
    private final Random random;
    private final int size;
    private String code;

    public CodeTicket() {
        this.alphabet = new char[] {
            'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z'
        };
        this.random = new Random();
        this.size = 6;
        this.code = generate();
    }

    public CodeTicket(String code) {
        this.alphabet = new char[] {
            'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z'
        };
        this.random = new Random();
        this.size = 6;
        this.code = code;
    }

    public String generate() {
        return NanoIdUtils.randomNanoId(random, alphabet, size);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
