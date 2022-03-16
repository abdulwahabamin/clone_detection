    private void updateSeekBar() {
        thread = new Thread() {
            @Override
            public void run() {
                while(mediaPlayer != null && mediaPlayer.isPlaying()) {
                    try {
                        Thread.sleep(50);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int currentPos = mediaPlayer.getCurrentPosition();
                                int duration = mediaPlayer.getDuration();
                                seekBar.setMax(duration);
                                seekBar.setProgress(currentPos);
                                updateTextViews(currentPos/1000 , duration /1000);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        thread.start();
    }

