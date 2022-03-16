    private void say(LinkedList<String> texts) {
        Locale locale = getLocaleForVoice();
        int available = tts.isLanguageAvailable(locale);
        if (available >= TextToSpeech.LANG_AVAILABLE) {
            tts.setLanguage(locale);
            tts.setSpeechRate(1.0f);
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                int counter = 0;
                for (String text: texts) {
                    if (TTS_DELAY_BETWEEN_ITEM.equals(text)) {
                        tts.playSilentUtterance(TTS_DELAY_BETWEEN_ITEM_IN_MS, TextToSpeech.QUEUE_ADD, "111111" + (counter++));
                    } else if (TTS_END.equals(text)) {
                        tts.playSilentUtterance(TTS_DELAY_BETWEEN_ITEM_IN_MS, TextToSpeech.QUEUE_ADD, TTS_END);
                    } else {
                        tts.speak(text, TextToSpeech.QUEUE_ADD, null, "111111" + (counter++));
                    }
                }
            } else {
                for (String text: texts) {
                    if (TTS_DELAY_BETWEEN_ITEM.equals(text)) {
                        tts.playSilence(TTS_DELAY_BETWEEN_ITEM_IN_MS, TextToSpeech.QUEUE_ADD, null);
                    } else {
                        tts.speak(text, TextToSpeech.QUEUE_ADD, null);
                    }
                }
            }
            sayWhatWhenRecreated = null;
        } else {
            appendLog(getBaseContext(), TAG, "Locale " + locale.toString() + " is not available in TTS");
            if (sayWhatWhenRecreated != null) {
                return;
            }
            sayWhatWhenRecreated = texts;
            timerHandler.postDelayed(timerRunnable, 1000);
        }
    }

