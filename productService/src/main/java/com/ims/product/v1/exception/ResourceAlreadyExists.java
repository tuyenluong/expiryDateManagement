package com.ims.product.v1.exception;

public class ResourceAlreadyExists extends RuntimeException {
    public ResourceAlreadyExists(String message) {
        super(message);
    }
}
