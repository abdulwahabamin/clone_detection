    /**
     * Concatenates basic app information string.
     */
    private String getAboutTextPart_1() {
        Resources res = getResources();

        String versionNumber = res.getString(R.string.about_version_number);
        String aboutText_1 = String.format(res.getString(R.string.about_1), versionNumber);
        aboutText_1 += res.getString(R.string.about_2);
        aboutText_1 += res.getString(R.string.about_3);
        aboutText_1 += res.getString(R.string.about_4);
        aboutText_1 += res.getString(R.string.about_5);
        aboutText_1 += res.getString(R.string.about_6);

        return aboutText_1;
    }

