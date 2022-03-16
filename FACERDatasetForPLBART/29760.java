  private Context updateResources(Context context, String language) {
    Locale locale = new Locale(language);
    Locale.setDefault(locale);

    Resources res = context.getResources();
    Configuration config = new Configuration(res.getConfiguration());
    if (AppUtil.isAtLeastVersion(JELLY_BEAN_MR1)) {
      config.setLocale(locale);
      context = context.createConfigurationContext(config);
    } else {
      config.locale = locale;
      res.updateConfiguration(config, res.getDisplayMetrics());
    }
    return context;
  }

