    public static AppNotification getInstance(Context context) {
        if(weakReference == null || weakReference.get() == null) {
            AppNotification appNotification = new AppNotification(context);
            weakReference = new WeakReference<AppNotification>(appNotification);
        }

        return weakReference.get();
    }

