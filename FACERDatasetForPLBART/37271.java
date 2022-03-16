    @Override
    public void onSpeechFinish(SpeechSynthesizer speechSynthesizer) {
        Log.i(TAG, "onSpeechFinish");
        handler.post(() -> {
            view.setSpeechFabEnable(true);
            view.setSpeechFabAnimation(false);
        });
    }

