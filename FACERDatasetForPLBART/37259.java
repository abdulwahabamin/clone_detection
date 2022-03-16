    @Override
    public void onCreate() {
        mSpeechSynthesizer = new SpeechSynthesizer(view.getContext(), "holder", this);
        mSpeechSynthesizer.setApiKey(BuildConfig.BD_TTS_API_KEY, BuildConfig.BD_TTS_SECRET_KEY);
        mSpeechSynthesizer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

