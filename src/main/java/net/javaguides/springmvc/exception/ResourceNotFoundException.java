package net.javaguides.springmvc.exception;

public class ResourceNotFoundException extends Exception {//사용자 지정 예외처리
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object resourId) {
        super(resourId != null ? resourId.toString() : null);
    }
} // 만약 객체가 null이 아니면 String으로 변환하고 null이면 아무겂도 하지 않는다.
