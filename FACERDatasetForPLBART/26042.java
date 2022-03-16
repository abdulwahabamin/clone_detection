    private static void writeToLog(final String logText) {
        final long timeMillis = System.currentTimeMillis();
        if (externalStorageExist()) {
            try {
                //按�?时分文件
                LogToES.writeLogToFile(LogToES.getLogPath(), createLogFileName(), logText, false, timeMillis);
            } catch (Throwable e) {
                Log.e("MLog", "writeToLog fail !" , e);
            }
        }
    }

