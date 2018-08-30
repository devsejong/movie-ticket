package net.chandol.study.movieticket.common.exception;

public class WorkInProgressException extends RuntimeException{
    public WorkInProgressException() {
        super("작업중입니다.");
    }
}
