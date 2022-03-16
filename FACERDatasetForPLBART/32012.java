    public static VoiceSettingParametersDbHelper getInstance(Context ctx) {
        if (instance == null) {
            instance = new VoiceSettingParametersDbHelper(ctx.getApplicationContext());
        }
        return instance;
    }

