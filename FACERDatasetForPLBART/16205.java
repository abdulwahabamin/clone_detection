    private void endService(boolean dismissNotification) {
        stopForeground(false);
        if(dismissNotification) {
            playerNotification.dismissPlayerNotification();
        } else {
            playerNotification.displayPlayerNotification(playQueue.getCurrentPlaying(), false, false);
        }
        stopSelf();
    }

