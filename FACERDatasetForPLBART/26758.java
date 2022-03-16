    @Override
    public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
        if (TextUtils.equals(getString(R.string.pref_unit_key), key)) {
            startService(new Intent(this, WeatherService.class));
           }
        if (TextUtils.equals(getString(R.string.pref_sync_key), key)) {
            WeatherJobService.scheduleJob(this);
        }
        if (TextUtils.equals(getString(R.string.pref_selected_lang_key), key)) {
            String newLang = prefs.getString(getString(R.string.pref_selected_lang_key), "en");
            LocaleHelper.setLocale(this, newLang);
            EventBus.getDefault().post(new ChangeEvent(ChangeEvent.CHANGE_LANGUAGE));
            recreate();
        }

    }

