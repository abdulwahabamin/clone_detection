    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_search:
                ActionHelper.returnToSearchActivity(this);
//                ActionHelper.startSearchActivity(this);
                return true;
            case R.id.action_audio_effects:
                ActionHelper.startAudioEffectActivity(this);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

