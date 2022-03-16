    /**
     * Concatenates credits and licenses string.
     */
    private String getAboutTextPart_2() {
        Resources res = getResources();

        int itemCount = 0;

        String aboutText_2 = "\n";
        aboutText_2 += res.getString(R.string.credits_1);
        aboutText_2 += "\n\n";
        aboutText_2 += getNextItemNumber(itemCount);
        itemCount++;
        aboutText_2 += res.getString(R.string.credits_2);
        aboutText_2 += res.getString(R.string.credits_3);
        aboutText_2 += res.getString(R.string.credits_4);
        aboutText_2 += res.getString(R.string.credits_5);
        aboutText_2 += getNextItemNumber(itemCount);
        itemCount++;
        aboutText_2 += res.getString(R.string.credits_6);
        aboutText_2 += res.getString(R.string.credits_7);
        aboutText_2 += res.getString(R.string.credits_8);
        aboutText_2 += res.getString(R.string.credits_9);
        aboutText_2 += getNextItemNumber(itemCount);
        itemCount++;
        aboutText_2 += res.getString(R.string.credits_10);
        aboutText_2 += res.getString(R.string.credits_11);
        aboutText_2 += res.getString(R.string.credits_115);
        aboutText_2 += res.getString(R.string.credits_12);
        aboutText_2 += res.getString(R.string.credits_13);
        aboutText_2 += getNextItemNumber(itemCount);
        itemCount++;
        aboutText_2 += res.getString(R.string.credits_131);
        aboutText_2 += res.getString(R.string.credits_132);
        aboutText_2 += res.getString(R.string.credits_133);
        aboutText_2 += res.getString(R.string.credits_134);
        aboutText_2 += res.getString(R.string.credits_135);
        aboutText_2 += getNextItemNumber(itemCount);
        itemCount++;
        aboutText_2 += res.getString(R.string.credits_14);
        aboutText_2 += res.getString(R.string.credits_15);
        aboutText_2 += getNextItemNumber(itemCount);
        itemCount++;
        aboutText_2 += res.getString(R.string.credits_16);
        aboutText_2 += res.getString(R.string.credits_165);
        aboutText_2 += res.getString(R.string.credits_17);
        aboutText_2 += getNextItemNumber(itemCount);
        itemCount++;
        aboutText_2 += res.getString(R.string.credits_18);
        aboutText_2 += "\n\n";

        String[] languages = res.getStringArray(R.array.translated_languages);
        String[] translators = res.getStringArray(R.array.translators);
        if (BuildConfig.DEBUG && languages.length != translators.length) {
            String errorMessage = "Number of languages: " + languages.length +
                    "; number of translators: " + translators.length;
            throw new AssertionError(errorMessage);
        }

        for (int i = 0; i < translators.length; i++) {
            String language = languages[i];
            String translator = translators[i];
            aboutText_2 += TRANSLATION_PREFIX;
            aboutText_2 += language;
            aboutText_2 += TRANSLATION_SEPARATOR;
            aboutText_2 += translator;
            aboutText_2 += "\n";
        }

        aboutText_2 += "\n";
        aboutText_2 += res.getString(R.string.credits_19);
        aboutText_2 += res.getString(R.string.credits_20);
        aboutText_2 += getNextItemNumber(itemCount);
        aboutText_2 += res.getString(R.string.credits_21);
        aboutText_2 += res.getString(R.string.credits_22);
        aboutText_2 += res.getString(R.string.credits_23);
        aboutText_2 += res.getString(R.string.credits_24);

        return aboutText_2;
    }

