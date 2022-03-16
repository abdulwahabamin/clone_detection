    private void sayWeather(final LinkedList<String> what) {
        appendLog(getBaseContext(), TAG, "Going to say: " + what);
        if (tts != null) {
            say(what);
            return;
        }
        recreateTts(what);
    }

