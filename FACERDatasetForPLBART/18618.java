        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();

            if (bundle.containsKey(Common.UPDATE_PAGER_POSTIION)) {
                //Update the queue fragment with the new song info.
                initMiniPlayer();
                initListViewAdapter(false);

            }

            //Updates the playback control buttons.
            if (intent.hasExtra(Common.UPDATE_PLAYBACK_CONTROLS))
                setPlayPauseButton();

            if (bundle.containsKey(Common.SERVICE_STOPPING)) {
                showEmptyTextView();

            }

        }

