    /**
     * {@inheritDoc}
     */
    @Override
    protected void onPause() {
        //Set out transition
        overridePendingTransition(R.anim.hold_in, R.anim.translate_to_left_out);
        super.onPause();
        // stop search if the activity moves out of the foreground
        if (mExecutable != null) {
            mExecutable.end();
        }
    }

