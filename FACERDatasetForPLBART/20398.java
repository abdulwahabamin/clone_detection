  /**
   * Toggle whether debug logging is enabled.
   * <p>
   * <b>WARNING:</b> Enabling this will result in excessive object allocation. This should be only
   * be used for debugging Picasso behavior. Do NOT pass {@code BuildConfig.DEBUG}.
   */
  public void setLoggingEnabled(boolean enabled) {
    loggingEnabled = enabled;
  }

