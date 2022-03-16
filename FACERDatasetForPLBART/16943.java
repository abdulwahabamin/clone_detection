    public static void startAudioEffectActivity(Activity activity) {
        try {
            Intent effects = new Intent(AudioEffect.ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL);
//            effects.putExtra(AudioEffect.EXTRA_AUDIO_SESSION, activity.getMediaBrowser().getSessionToken());
            activity.startActivityForResult(effects, 5 << 5);
        } catch (Exception e) {
            Toast.makeText(activity, R.string.no_equalizer, Toast.LENGTH_LONG).show();
            FireLog.e(TAG, "", e);
        }
    }

