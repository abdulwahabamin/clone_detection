    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_search:
                ActionHelper.startSearchActivity(this);
                return true;
            case R.id.action_audio_effects:
                ActionHelper.startAudioEffectActivity(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

