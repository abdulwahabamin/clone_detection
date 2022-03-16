    @Override
    public void onStartWorking(SpeechSynthesizer speechSynthesizer) {
        Log.i(TAG, "onStartWorking");
        handler.post(() -> {
            view.setSpeechFabEnable(false);
            view.setSpeechFabAnimation(true);
        });
    }

