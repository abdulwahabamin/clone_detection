    private void startLogoAnimation() {
        Animation zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        zoomIn.reset();
        musicLogo = (AppCompatImageView) findViewById(R.id.music_logo);
        musicLogo.clearAnimation();
        musicLogo.startAnimation(zoomIn);
    }

