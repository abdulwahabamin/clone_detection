  /** Skips {@code target - current} bytes and returns. */
  private void skip(long current, long target) throws IOException {
    while (current < target) {
      long skipped = in.skip(target - current);
      if (skipped == 0) {
        if (read() == -1) {
          break; // EOF
        } else {
          skipped = 1;
        }
      }
      current += skipped;
    }
  }

