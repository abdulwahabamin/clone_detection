    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        try {
            dumpException2SDCard(ex);
            uploadException2Server(ex);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ex.printStackTrace();
        if (null != mDefaultCrashHandler) {
            mDefaultCrashHandler.uncaughtException(thread, ex);
        } else {
            Process.killProcess(Process.myPid());
        }
    }

