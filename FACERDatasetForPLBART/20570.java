  static byte[] toByteArray(InputStream input) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024 * 4];
    int n;
    while (-1 != (n = input.read(buffer))) {
      byteArrayOutputStream.write(buffer, 0, n);
    }
    return byteArrayOutputStream.toByteArray();
  }

