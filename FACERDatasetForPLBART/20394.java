  /**
   * Toggle whether debug display, logging, and statistics are enabled.
   * <p>
   *
   * @deprecated Use {@link #setIndicatorsEnabled(boolean)} and {@link #setLoggingEnabled(boolean)}
   * instead.
   */
  @SuppressWarnings("UnusedDeclaration") @Deprecated public void setDebugging(boolean debugging) {
    setIndicatorsEnabled(debugging);
  }

