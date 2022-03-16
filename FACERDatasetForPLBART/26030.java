    public static void infoWithoutLineNumber(Object obj, String format, Object... args) {
        if (shouldWriteInfo()) {
            try {
                outputInfo(obj, format, args);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

