package cz.cvut.fit.tjv.soukuj26.semestral_work.business.exceptions;

/**
 * A checked exception indicating problem related to existence of an entity.
 */
public class EntityStateException extends RuntimeException {
    public <E> EntityStateException(E entity) {
        super("Illegal state of entity " + entity);
    }
}
