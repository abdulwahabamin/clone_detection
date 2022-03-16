    private void recreateTts() {
        TextToSpeech.OnInitListener onInitListener = new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                appendLog(getBaseContext(), TAG, "TextToSpeech initialized with status: " + status);
                if ((tts != null) && (status == TextToSpeech.SUCCESS)) {
                    prepareTtsLanguages();
                }
            }
        };
        tts = new TextToSpeech(getBaseContext(), onInitListener);
    }

