    private void doPauseResume() {
        if (service != null) {
            if (service.isPlaying()) {
                service.pause();
            } else {
                service.play();
            }
            refreshNow();
            setPauseButtonImage();
        }
    }

