  /**
   * Makes sure that the underlying stream can backtrack the full range from
   * {@code reset} thru {@code limit}. Since we can't call {@code mark()}
   * without also adjusting the reset-to-position on the underlying stream this
   * method resets first and then marks the union of the two byte ranges. On
   * buffered streams this additional cursor motion shouldn't result in any
   * additional I/O.
   */
  private void setLimit(long limit) {
    try {
      if (reset < offset && offset <= this.limit) {
        in.reset();
        in.mark((int) (limit - reset));
        skip(reset, offset);
      } else {
        reset = offset;
        in.mark((int) (limit - offset));
      }
      this.limit = limit;
    } catch (IOException e) {
      throw new IllegalStateException("Unable to mark: " + e);
    }
  }

