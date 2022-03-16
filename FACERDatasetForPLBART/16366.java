    /**
     * �?始化 全局异常上报
     * <p>
     * Crash 异常处�?�
     */
    protected void initCrashHandler() {
        Cockroach.install(new ExceptionHandler() {
            @Override
            protected void onUncaughtExceptionHappened(Thread thread, Throwable throwable) {
                KLog.w("onUncaughtExceptionHappened:" + AppUtils.getErrorInfo(throwable));
            }

            @Override
            protected void onBandageExceptionHappened(Throwable throwable) {
                KLog.w("onBandageExceptionHappened:" + AppUtils.getErrorInfo(throwable));
            }

            @Override
            protected void onEnterSafeMode() {
                KLog.w("onEnterSafeMode");
            }

            @Override
            protected void onMayBeBlackScreen(Throwable e) {
                super.onMayBeBlackScreen(e);
                KLog.w("onMayBeBlackScreen:" + AppUtils.getErrorInfo(e));
            }
        });
    }

