    public RemoteControlClientCompat(PendingIntent pendingIntent, Looper looper) {
        if (!sHasRemoteControlAPIs) {
            return;
        }

        try {
            mActualRemoteControlClient =
                    sRemoteControlClientClass.getConstructor(PendingIntent.class, Looper.class)
                            .newInstance(pendingIntent, looper);
        } catch (Exception e) {
            Log.e(TAG, "Error creating new instance of " + sRemoteControlClientClass.getName(), e);
        }
    }

