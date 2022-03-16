    private Notification buildNotification() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        {
            return buildJBNotification();}
        else
            return buildICSNotification();
    }

