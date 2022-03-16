    public static void warnWithoutLineNumber(Object obj, String format, Object... args) {
        if (shouldWriteWarn()) {
            try {
                outputWarning(obj, format, args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

