    public static boolean isOpen() {
        synchronized (mLock) {
            BufferedWriter writer = mWriter;
            return writer != null;
        }
    }

