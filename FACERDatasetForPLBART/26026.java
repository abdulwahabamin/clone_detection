    public static void verboseWithoutLineNumber(Object obj, String format, Object... args) {
        final boolean shouldOutputVerboseToDDMS = shouldOutputVerboseToDDMS();
        final boolean shouldOutputVerboseToFile = shouldOutputVerboseToFile();
        if (shouldOutputVerboseToDDMS || shouldOutputVerboseToFile) {
            try {
                outputVerbose(obj, format,
                        shouldOutputVerboseToDDMS, shouldOutputVerboseToFile, args);
            } catch (java.util.IllegalFormatException e) {
                e.printStackTrace();
            }
        }
    }

