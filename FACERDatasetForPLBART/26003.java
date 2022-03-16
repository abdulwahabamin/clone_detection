    public static void writeLog(String path, String fileName, String msg,
                                boolean immediateClose, long timeMillis) throws IOException {
        if (path == null || path.length() == 0 || fileName == null || fileName.length() == 0) {
            return;
        }
        File dirFile = new File(path);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        boolean needCreate = false;

        File logFile = new File(dirFile, fileName);
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
                /*LogManager.getInstance().addSingleLogRecord(fileName.substring(0, fileName.length() - 4));
                LogManager.getInstance().deleteOldLogs();
                LogManager.getInstance().checkAndCompressLog();;

                *//*SET PATH*//*
                if(LogManager.getInstance().getPathListener() != null && logFile != null){
                    LogManager.getInstance().getPathListener().updateCurrentLogPath(logFile.getAbsolutePath());
                }*/


            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        } else {
            long fileSize = (logFile.length() >>> 20);// convert to M bytes
            if (fileSize >= MAX_FILE_SIZE) {
                return;
            }
        }

        Calendar logCal = logCalendar.get();
        logCal.setTimeInMillis(timeMillis);
        String strLog = LOG_FORMAT.format(logCal);
//        String strLog = LOG_FORMAT.format(timeMillis);

        StringBuffer sb = new StringBuffer(strLog.length() + msg.length() + 4);
        sb.append(strLog);
        sb.append(' ');
        sb.append(msg);
        sb.append('\n');
        strLog = sb.toString();

        synchronized (mLock) {
            if (mPath == null) {
                mPath = logFile.getAbsolutePath();
                needCreate = true;
            } else if (!equal(mPath, logFile.getAbsolutePath())) {
                BufferedWriter writer = mWriter;
                if (writer != null) {
                    writer.close();
                }
                mWriter = null;
                mPath = null;
                needCreate = true;
            }

            BufferedWriter bufWriter = mWriter;

            if (needCreate || bufWriter == null) {
                mPath = logFile.getAbsolutePath();
                FileWriter fileWriter = new FileWriter(logFile, true);
                bufWriter = new BufferedWriter(fileWriter, BUFF_SIZE);
                mWriter = bufWriter;
            }

            // we can make FileWriter static, but when to close it
            bufWriter.write(strLog);

            // It doesn't matter there are multiple files gets mixed.
            final long curMillis = SystemClock.elapsedRealtime();
            if (curMillis - mLastMillis >= FLUSH_INTERVAL) {
                bufWriter.flush();
                mLastMillis = curMillis;
            }

            if (immediateClose) {
                bufWriter.close();
                mPath = null;
                mWriter = null;
            }
        }
    }

