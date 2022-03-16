    @Override
    public int onStartCommand(final Intent intent, int flags, int startId)
    {
        appContext = getApplicationContext();
        final String[] paths = intent.getStringArrayExtra("PATHS");
        FileOp op = (FileOp) intent.getSerializableExtra("OPERATION");


        progressNotification = (NotificationManager) getSystemService(appContext.NOTIFICATION_SERVICE);
        handler = new Handler();

        nBuilder = new NotificationCompat.Builder(this, appContext.getString(R.string.IONotifChannel));
        nBuilder.setContentTitle(getResources().getString(R.string.app_name));
        nBuilder.setSmallIcon(R.drawable.io_notify_icon);
        nBuilder.setProgress(0, 0, true);


        switch (op)
        {
            case COPY:
                nBuilder.setContentText("Copy in progress");
                break;
            case CUT:
                nBuilder.setContentText("Cut in progress");
                break;
            case DELETE:
                nBuilder.setContentText("Delete in progress");
                break;
            default:
                // no mode specified
                stopSelf();
                return START_NOT_STICKY;
        }
        t =  new Thread(new IOThread(paths, op, this));
        progressNotification.notify(notifyId, nBuilder.build());
        t.start();
        return START_NOT_STICKY;
    }

