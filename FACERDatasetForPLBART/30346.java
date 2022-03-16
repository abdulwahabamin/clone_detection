    /**
     * 当 UncaughtException �?�生时会转入该函数�?�处�?�
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            // 如果用户没有处�?�则让系统默认的异常处�?�器�?�处�?�  
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.e(TAG, "error : ", e);
            }

            // 退出程�?
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

