package com.azoraqua.language.api;

import java.util.*;

public final class TranslationSet {

    private final Set<Translation> translations;

    public TranslationSet(Set<Translation> translations) {
        this.translations = (translations != null ? translations : new HashSet<>());
    }

    public TranslationSet() {
        this(null);
    }

    public Collection<Translation> getTranslations() {
        return Collections.unmodifiableCollection(translations);
    }

    public Translation getTranslation(String key) {
        return translations.stream()
            .filter(t -> t.getKey().equalsIgnoreCase(key))
            .findAny()
            .orElse(new Translation(null, key));
    }
}
