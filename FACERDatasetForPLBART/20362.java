  @Override public int read(byte[] buffer, int offset, int length) throws IOException {
    int count = in.read(buffer, offset, length);
    if (count != -1) {
      this.offset += count;
    }
    return count;
  }

