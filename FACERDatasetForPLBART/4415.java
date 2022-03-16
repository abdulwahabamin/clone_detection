    public static void closeAndRestartBrief(Activity activity) {
        //Intent mStartActivity = new Intent(activity, Main.class);
        //int mPendingIntentId = 123456;
        //PendingIntent mPendingIntent = PendingIntent.getActivity(activity, mPendingIntentId,    mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
        //AlarmManager mgr = (AlarmManager)activity.getSystemService(Context.ALARM_SERVICE);
        //mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
        activity.recreate();//.finish();
        //activity.startActivity(mStartActivity);
        //System.exit(0);
    }

