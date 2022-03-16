    private void Animation(float y, int duration, float alpha) {
        mBothmusicPlayer.animate()
                .y(y)
                .setDuration(duration)
                .setInterpolator(new AccelerateInterpolator())
                .start();
        mMiniMusicPlayer.animate()
                .alpha(alpha)
                .setDuration(duration)
                .setInterpolator(new AccelerateInterpolator())
                .start();
    }

