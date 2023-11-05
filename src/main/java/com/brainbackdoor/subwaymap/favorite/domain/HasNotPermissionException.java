package com.brainbackdoor.subwaymap.favorite.domain;

public class HasNotPermissionException extends RuntimeException {
    public HasNotPermissionException(String message) {
        super(message);
    }
}
