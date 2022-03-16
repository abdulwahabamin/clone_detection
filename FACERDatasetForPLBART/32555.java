    private void recreateTts(final LinkedList<String> what) {
        TextToSpeech.OnInitListener onInitListener = new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                appendLog(getBaseContext(), TAG, "TextToSpeech initialized with status: " + status);
                if ((tts != null) && (status == TextToSpeech.SUCCESS) && (what != null)) {
                    say(what);
                }
            }
        };
        tts = new TextToSpeech(getBaseContext(), onInitListener);
    }

