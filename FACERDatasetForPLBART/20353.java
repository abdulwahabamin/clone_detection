  public MarkableInputStream(InputStream in, int size) {
    if (!in.markSupported()) {
      in = new BufferedInputStream(in, size);
    }
    this.in = in;
  }

