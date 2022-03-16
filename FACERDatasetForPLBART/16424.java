    /**
     * 替�?�ActivityThread.mH.mCallback，实现拦截Activity生命周期，直接忽略生命周期的异常的�?会导致黑�?，目�?
     * 会调用ActivityManager的finishActivity结�?�掉生命周期抛出异常的Activity
     */
    private static void initActivityKiller() {
        //�?�版本android的ActivityManager获�?�方�?，finishActivity的�?�数，token(binder对象)的获�?��?一样
        if (Build.VERSION.SDK_INT >= 26) {
            sActivityKiller = new ActivityKillerV26();
        } else if (Build.VERSION.SDK_INT == 25 || Build.VERSION.SDK_INT == 24) {
            sActivityKiller = new ActivityKillerV24_V25();
        } else if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 23) {
            sActivityKiller = new ActivityKillerV21_V23();
        } else if (Build.VERSION.SDK_INT >= 15 && Build.VERSION.SDK_INT <= 20) {
            sActivityKiller = new ActivityKillerV15_V20();
        } else if (Build.VERSION.SDK_INT < 15) {
            sActivityKiller = new ActivityKillerV15_V20();
        }

        try {
            hookmH();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

