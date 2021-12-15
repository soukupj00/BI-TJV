package cz.cvut.fit.tjv.soukuj26.semestral_work.api.exception;

public class NoEntityFoundException extends RuntimeException {

    public NoEntityFoundException() {
        super("No entity found");
    }
}
