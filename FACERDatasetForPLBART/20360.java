  @Override public int read() throws IOException {
    int result = in.read();
    if (result != -1) {
      offset++;
    }
    return result;
  }

