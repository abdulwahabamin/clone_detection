  /**
   * {@code true} if debug display, logging, and statistics are enabled.
   * <p>
   *
   * @deprecated Use {@link #areIndicatorsEnabled()} and {@link #isLoggingEnabled()} instead.
   */
  @SuppressWarnings("UnusedDeclaration") @Deprecated public boolean isDebugging() {
    return areIndicatorsEnabled() && isLoggingEnabled();
  }

