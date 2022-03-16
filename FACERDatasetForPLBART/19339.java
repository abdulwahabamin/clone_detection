        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()) {
                case R.id.equalizer:
                    Intent intent = new Intent(getActivity(), EqualizerActivity.class);
                    startActivity(intent);
                    break;
                case R.id.save_clear_current_position:
                    String songId = mApp.getService().getCurrentSong().getId();
                    if (item.getTitle().equals(mContext.getResources().getString(R.string.save_current_position))) {
                        item.setTitle(R.string.clear_saved_position);

                        long currentPositionMillis = mApp.getService().getCurrentMediaPlayer().getCurrentPosition();
                        String message = mContext.getResources().getString(R.string.track_will_resume_from);
                        message += " " + mApp.convertMillisToMinsSecs(currentPositionMillis);
                        message += " " + mContext.getResources().getString(R.string.next_time_you_play_it);

                        mApp.getDBAccessHelper().setLastPlaybackPosition(songId, currentPositionMillis);
                        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();

                    } else {
                        item.setTitle(R.string.save_current_position);
                        mApp.getDBAccessHelper().setLastPlaybackPosition(songId, -1);
                        Toast.makeText(mContext, R.string.track_start_from_beginning_next_time_play, Toast.LENGTH_LONG).show();

                    }

                    //Requery the database and update the service cursor.
                    mApp.getPlaybackKickstarter().updateServiceCursor();

                    break;
                case R.id.show_embedded_lyrics:
                    if (item.getTitle().equals(mContext.getResources().getString(R.string.show_embedded_lyrics))) {
                        AsyncLoadLyricsTask task = new AsyncLoadLyricsTask();
                        task.execute();
                        item.setTitle(R.string.hide_lyrics);
                    } else {
                        hideLyrics();
                        item.setTitle(R.string.show_embedded_lyrics);
                    }

                    break;
                case R.id.a_b_repeat:
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ABRepeatDialog dialog = new ABRepeatDialog();
                    dialog.show(ft, "repeatSongRangeDialog");
                    break;
                case R.id.current_queue:
                    ((NowPlayingActivity) getActivity()).toggleCurrentQueueDrawer();
                    break;
                case R.id.go_to:
                    PopupMenu goToPopupMenu = new PopupMenu(getActivity(), overflowIcon);
                    goToPopupMenu.inflate(R.menu.show_more_menu);
                    goToPopupMenu.setOnMenuItemClickListener(goToMenuClickListener);
                    goToPopupMenu.show();
                    break;
            }

            return false;
        }

