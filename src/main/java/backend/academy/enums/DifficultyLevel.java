package backend.academy.enums;

public enum DifficultyLevel {
    EASY(10, "Легкий"),
    MEDIUM(7, "Средний"),
    HARD(6, "Сложный");

    private final int attempts;
    private final String digitLevelName;

    DifficultyLevel(int attempts, String digitLevelName) {
        this.attempts = attempts;
        this.digitLevelName = digitLevelName;
    }

    public int getAttempts() {
        return attempts;
    }

    public static DifficultyLevel fromLevel(int level) {
        return switch (level) {
            case 0 -> EASY;
            case 1 -> MEDIUM;
            case 2 -> HARD;
            default -> throw new IllegalArgumentException("Неверный уровень сложности");
        };
    }
}

