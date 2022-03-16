    public static <D extends Durable> D readFromArrayOrNull(byte[] data, D d) {
        try {
            return readFromArray(data, d);
        } catch (IOException e) {
            Log.w(TAG, "Failed to read", e);
            return null;
        }
    }

