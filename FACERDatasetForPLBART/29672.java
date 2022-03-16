  private void initVariables(View view) {
    currentLanguage = MyApplication.localeManager.getLanguage();
    activity = getActivity();
    if (activity != null) {
      Drawable drawable = activity.getResources().getDrawable(R.drawable.ic_done_black_24dp);
      String versionName = "";
      try {
        versionName = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
      } catch (PackageManager.NameNotFoundException e) {
        // do nothing
      }
      setTextWithLinks(view.findViewById(R.id.text_application_info), getString(R.string.application_info_text, versionName));
      setTextWithLinks(view.findViewById(R.id.text_developer_info), getString(R.string.developer_info_text));
      setTextWithLinks(view.findViewById(R.id.text_design_api), getString(R.string.design_api_text));
      setTextWithLinks(view.findViewById(R.id.text_libraries), getString(R.string.libraries_text));
      setTextWithLinks(view.findViewById(R.id.text_license), getString(R.string.license_text));
      if (currentLanguage.equals(LocaleManager.LANGUAGE_ENGLISH)) {
        englishButton.setIcon(drawable);
      } else {
        persianButton.setIcon(drawable);
      }
    }
    nightModeSwitch.setChecked(SharedPreferencesUtil.getInstance(activity).isDarkThemeEnabled());
    nightModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SharedPreferencesUtil.getInstance(activity).setDarkThemeEnabled(isChecked);
        if (isChecked) {
          AppCompatDelegate.setDefaultNightMode(
              AppCompatDelegate.MODE_NIGHT_YES);
        } else {
          AppCompatDelegate.setDefaultNightMode(
              AppCompatDelegate.MODE_NIGHT_NO);
        }
        activity.recreate();
      }
    });
  }

