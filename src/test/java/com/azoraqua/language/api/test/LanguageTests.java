package com.azoraqua.language.api.test;

import com.azoraqua.language.api.LanguageAPI;
import com.azoraqua.language.api.TranslationSet;
import org.junit.jupiter.api.*;

import java.util.Locale;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public final class LanguageTests {

    // Use for testing purposes.
    private static TranslationSet translationSet;

    @Order(1)
    @Test
    public void test_retrieve_translation_set() {
       translationSet = LanguageAPI.getTranslations(Locale.forLanguageTag("example"));

        Assertions.assertNotNull(translationSet);
    }

    @Order(2)
    @Test
    public void test_retrieve_translations() {
        Assertions.assertNotNull(translationSet.getTranslations());

    }

    @Order(3)
    @Test
    public void test_translations_present() {
        Assertions.assertTrue(translationSet.getTranslations().size() > 0);
    }

    @Order(4)
    @Test
    public void test_message_correct() {
        Assertions.assertEquals("Hello {who}!", translationSet.getTranslation("hello").getMessage());
    }

    @Order(5)
    @Test
    public void test_message_contains_placeholder() {
        Assertions.assertTrue( translationSet.getTranslation("hello").getPlaceholders().contains("{who}"));
    }
}
