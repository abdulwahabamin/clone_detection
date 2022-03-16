  @OnClick({R.id.english_button, R.id.persian_button})
  void handleChangeLanguage(View view) {
    switch (view.getId()) {
      case R.id.english_button:
        if (currentLanguage.equals(LocaleManager.LANGUAGE_PERSIAN)) {
          MyApplication.localeManager.setNewLocale(activity, LocaleManager.LANGUAGE_ENGLISH);
          restartActivity();
        }
        break;
      case R.id.persian_button:
        if (currentLanguage.equals(LocaleManager.LANGUAGE_ENGLISH)) {
          MyApplication.localeManager.setNewLocale(activity, LocaleManager.LANGUAGE_PERSIAN);
          restartActivity();
        }
        break;
    }
  }

