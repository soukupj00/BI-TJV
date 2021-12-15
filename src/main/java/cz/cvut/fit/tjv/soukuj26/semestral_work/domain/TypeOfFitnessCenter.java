package cz.cvut.fit.tjv.soukuj26.semestral_work.domain;

public enum TypeOfFitnessCenter {
    ALL_PURPOSE,
    STRONGMAN,
    POWERLIFTING,
    CROSSFIT,
    BODYBUILDING;

    public static TypeOfFitnessCenter fromInteger(Integer i) {
        return switch (i) {
            case 1 -> ALL_PURPOSE;
            case 2 -> STRONGMAN;
            case 3 -> POWERLIFTING;
            case 4 -> CROSSFIT;
            case 5 -> BODYBUILDING;
            default -> ALL_PURPOSE;
        };
    }
}
