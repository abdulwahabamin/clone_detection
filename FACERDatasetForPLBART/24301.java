    private void updateTrackInfo() {
        if (service == null) return;

        if (service.getQueueLength() > 0) {
            setTitle((service.getQueuePosition() + 1) + "/" + service.getQueueLength());
        } else {
            finish();
        }
    }

