    public static <D extends Durable> byte[] writeToArrayOrNull(D d) {
        try {
            return writeToArray(d);
        } catch (IOException e) {
            Log.w(TAG, "Failed to write", e);
            return null;
        }
    }

