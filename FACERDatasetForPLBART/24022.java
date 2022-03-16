    @Override
    public void previousOrRestartCurrent() {
        if (position() < PREV_THRESHOLD_MILLIS) {
            previous();
        } else {
            seek(0);
        }
    }

