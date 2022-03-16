    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_audio_effects:
                ActionHelper.startAudioEffectActivity(this);
                return true;
            case R.id.action_share:
                ActionHelper.shareTrack(this, getMediaDescription());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

