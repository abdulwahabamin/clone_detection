  /**
   * Returns an opaque token representing the current position in the stream.
   * Call {@link #reset(long)} to return to this position in the stream later.
   * It is an error to call {@link #reset(long)} after consuming more than
   * {@code readLimit} bytes from this stream.
   */
  public long savePosition(int readLimit) {
    long offsetLimit = offset + readLimit;
    if (limit < offsetLimit) {
      setLimit(offsetLimit);
    }
    return offset;
  }

