    private void stop() {
        if (mp != null) {
            try {
                if (mp.isPlaying()) {
                    mp.pause();
                }
                mp.seekTo(0);
            } catch (Exception e) {
                // Toast.makeText(getApplicationContext(), getString(R.string.exception) + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

