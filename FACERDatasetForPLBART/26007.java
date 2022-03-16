    /**
     * 获�?�日志备份创建时间，通过文件�??判断，如果是备份文件就解�?，解�?�?到就返回文件最�?�修改时间
     * @param file file
     * @return 0 or backup millis or lastModified millis
     */
    private static long getLogFileBackupTime(File file) {
        if (file == null || !file.exists() || !isBakFile(file.getAbsolutePath())) {
            return 0;
        }
        long time = 0;
        try {
            String filename = file.getName();
            Matcher matcher = PATTERN.matcher(filename);
            if (matcher.find()) {
                String dateStr = filename.substring(matcher.start(), matcher.end());
                time = getSimpleDateFormat(BAK_DATE_FORMAT_STR).parse(dateStr).getTime();
                Log.i("LogToES", ".bak name:" + dateStr + ", time" + time + ", str:" + simpleDateFormat.format(time));
            } else {
                time = file.lastModified();
                Log.i("LogToES", ".bak find time format wrong, filename:" + filename + ", lastModified:" + time);
            }
        } catch (Throwable throwable) {
            Log.e("LogToES", "getLogFileBackupTime error" + throwable);
            time = file.lastModified();
            Log.i("LogToES", ".bak lastModified:" + time);
        }
        return time;
    }

