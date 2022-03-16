    public static void errorWithoutLineNumber(Object obj, String format, Object... args) {
        if (shouldWriteError()) {
            try {
                outputError(obj, format, args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

