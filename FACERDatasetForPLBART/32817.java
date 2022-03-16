    private static boolean initFileLogging(File logFile) {
        char[] logFileDateCreatedBytes = new char[TIME_DATE_PATTERN.length()];
        Date logFileDateCreated;
        FileReader logFileReader = null;
        try {
            logFileReader = new FileReader(logFile);
            logFileReader.read(logFileDateCreatedBytes);
            logFileDateCreated = DATE_FORMATTER.parse(new String(logFileDateCreatedBytes));
        } catch (Exception e) {
            return false;
        } finally {
            if (logFileReader != null) {
                try {
                    logFileReader.close();
                } catch (IOException ex) {

                }
            }
        }
        initEndOfLive(logFileDateCreated);
        return true;
    }

