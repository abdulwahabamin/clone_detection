  /**
   * Set the duration.
   *
   * @param duration The duration.
   *                 <ul>
   *                 <li>{@link Duration#LENGTH_INDEFINITE}</li>
   *                 <li>{@link Duration#LENGTH_SHORT     }</li>
   *                 <li>{@link Duration#LENGTH_LONG      }</li>
   *                 </ul>
   * @return the single {@link SnackbarUtil} instance
   */
  public SnackbarUtil setDuration(@Duration final int duration) {
    this.duration = duration;
    return this;
  }

