    public boolean stopPlayback() {

        try {
            getCurrentMediaPlayer().stop();
            updateNotification();
            MainActivity.changeUI();
            //updateWidgets();

        } catch (Exception e) {
            return false;
        }

        return true;
    }

