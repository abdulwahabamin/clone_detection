    @Override
    public void update(Observable o, Object arg)
    {
        final String msg = (String) arg;
        nBuilder.setContentText(msg);
        nBuilder.setProgress(100, 100, false);
        progressNotification.notify(notifyId, nBuilder.build());

        handler.post(new Runnable()
        {
            public void run()
            {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        stopSelf();
    }

