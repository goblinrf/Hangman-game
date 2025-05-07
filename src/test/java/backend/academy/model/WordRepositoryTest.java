package backend.academy.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WordRepositoryTest {

    private WordRepository wordRepository;

    @BeforeEach
    void setUp() {
        wordRepository = new WordRepository();
    }

    @Test
    void givenCategoryAndLevel_whenGetWord_thenCorrectWordIsReturned() {

        String category = "животные";
        int level = 0;
        int index = 0;

        String word = WordRepository.getWord(category, level, index);

        assertEquals(word,"ёж");
    }
}
