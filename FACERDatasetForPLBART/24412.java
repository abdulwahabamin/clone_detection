    private long refreshNow() {
        if (service == null) return 500;

        long pos = posOverride < 0 ? service.position() : posOverride;
        long remaining = 1000 - (pos % 1000);
        long duration = service.duration();
        if ((pos >= 0) && (duration > 0)) {
            currentTime.setText(MusicUtils.formatDuration(getActivity(), pos));

            if (service.isPlaying()) {
                currentTime.setVisibility(View.VISIBLE);
            } else {
                // blink the counter
                int vis = currentTime.getVisibility();
                currentTime.setVisibility(vis == View.INVISIBLE ? View.VISIBLE : View.INVISIBLE);
                remaining = 500;
            }

            progressBar.setProgress((int) (1000 * pos / duration));
        } else {
            currentTime.setText("--:--");
            progressBar.setProgress(1000);
        }
        // return the number of milliseconds until the next full second, so
        // the counter can be updated at just the right time
        return remaining;
    }

