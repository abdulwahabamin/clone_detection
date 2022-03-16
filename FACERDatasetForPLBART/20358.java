  /** Resets the stream to the position recorded by {@code token}. */
  public void reset(long token) throws IOException {
    if (offset > limit || token < reset) {
      throw new IOException("Cannot reset");
    }
    in.reset();
    skip(reset, token);
    offset = token;
  }

