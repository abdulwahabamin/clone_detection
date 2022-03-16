    private void pause() {
        if (mp != null) {
            try {
                if (mp.isPlaying()) {
                    mp.pause();
                    // Changing button image to play button
                    btnPlay.setImageResource(android.R.drawable.ic_media_play);
                }
            } catch (Exception e) {
                // Toast.makeText(getApplicationContext(), getString(R.string.exception) + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

