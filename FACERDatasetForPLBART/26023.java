    private static boolean setOptions(LogOptions options) {
        final LogOptions tmpOp = (options == null ? new LogOptions() : options);
        sOptions = tmpOp;
        sOptions.logIdentifier = sOptions.logFileName.substring(0,sOptions.logFileName.indexOf("."));
        LogToES.setBackupLogLimitInMB(tmpOp.backUpLogLimitInMB);
        LogToES.setBuffSize(tmpOp.buffSizeInBytes);
        return tmpOp.buffSizeInBytes > 0
                && !isNullOrEmpty(tmpOp.logFileName);
    }

