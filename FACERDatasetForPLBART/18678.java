    @Override
    public void onPause() {
    	super.onPause();

        //Save the EQ values for the current song.
        if (!mDoneButtonPressed) {
           setEQValuesForSong(mApp.getService().getCurrentSong().getId());
           Toast.makeText(mContext, R.string.eq_applied_to_current_song, Toast.LENGTH_SHORT).show();
        }

        finish();
    }

