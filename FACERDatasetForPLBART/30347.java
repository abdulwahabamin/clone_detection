    /**
     * 自定义错误处�?�，收集错误信�?�，�?��?错误报告等�?作�?�在此完�?
     *
     * @return true：如果处�?�了该异常信�?�；�?�则返回 false
     */
    private boolean handleException(final Throwable ex) {
        if (ex == null) {
            return false;
        }

        // 使用 Toast �?�显示异常信�?�  
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                logger.error("系统异常退出", ex);

//                Toast.makeText(mContext, "很抱歉，程�?出现异常，�?�将退出。!!!!"+path, Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }.start();

        // 收集设备�?�数信�?�  
        collectDeviceInfo(mContext);
        // �?存日志文件  
        String path = saveCrashInfo2File(ex);
        Log.d(TAG, "handleException: " + path);
        return true;
    }

