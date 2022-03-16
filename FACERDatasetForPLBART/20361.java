  @Override public int read(byte[] buffer) throws IOException {
    int count = in.read(buffer);
    if (count != -1) {
      offset += count;
    }
    return count;
  }

