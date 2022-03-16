    public RemoteControlClientCompat(PendingIntent pendingIntent) {
        if (!sHasRemoteControlAPIs) {
            return;
        }
        try {
            mActualRemoteControlClient =
                    sRemoteControlClientClass.getConstructor(PendingIntent.class)
                            .newInstance(pendingIntent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

