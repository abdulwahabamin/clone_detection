    private void initTts() {
        if (tts != null) {
            prepareTtsLanguages();
            return;
        }
        recreateTts();
    }

