    public static <D extends Durable> D readFromArray(byte[] data, D d) throws IOException {
        if (data == null) throw new IOException("Missing data");
        final ByteArrayInputStream in = new ByteArrayInputStream(data);
        d.reset();
        try {
            d.read(new DataInputStream(in));
        } catch (IOException e) {
            d.reset();
            throw e;
        }
        return d;
    }

