    private synchronized void handlePlayerCallback(int player, Message msg) {
        switch (msg.what) {
            case MyMediaPlayer.SERVER_DIED:
                Log.d(TAG, "MediaPlayer died: " + player);
                if (mIsSupposedToBePlaying) {
                    next();
                } else {
                    // the server died when we were idle, so just reopen the same song
                    // (it will start again from the beginning though when the user restarts)
                    if (mPlayListLen > 0) {
                        if (prepare(mPlayList[mPlayPos])) {
                            fetchMetadata(mPlayList[mPlayPos]);
                        }
                    }
                }
                break;

            case MyMediaPlayer.RELEASE_WAKELOCK:
                Log.d(TAG, "MediaPlayer release wakelock: " + player);
                mPlayers[player].releaseWakeLock();
                break;


            case MyMediaPlayer.TRACK_ENDED:
                int fadeSeconds = Integer.parseInt(mSettings.getString(SettingsActivity.FADE_SECONDS, "0"));
                mPlaybackHander.removeMessages(DUCK);
                mPlaybackHander.removeMessages(FADEDOWN);
                mPlaybackHander.removeMessages(CROSSFADE);
                switch (mRepeatMode) {
                    case REPEAT_STOPAFTER:
                        Log.d(TAG, "MediaPlayer track ended, REPEAT_STOPAFTER: " + player);
                        if (mSession != null) {
                            deactivateMediaSession();
                        }
                        gotoIdleState();
                        notifyChange(PLAYSTATE_CHANGED);
                        break;

                    case REPEAT_CURRENT:
                        Log.d(TAG, "MediaPlayer track ended, REPEAT_CURRENT: " + player);
                        seek(0);
                        if (fadeSeconds > 0) {
                            mCurrentVolume[mCurrentPlayer] = 0f;
                        }
                        play();
                        break;

                    case REPEAT_NONE:
                    case REPEAT_ALL:
                        Log.d(TAG, "MediaPlayer track ended, REPEAT_NONE/REPEAT_ALL: " + player);
                        if (mPlayListLen <= 0) {
                            if (mSession != null) {
                                deactivateMediaSession();
                            }
                            gotoIdleState();
                            notifyChange(PLAYSTATE_CHANGED);
                            break;
                        }

                        if (mPlayPos >= mPlayListLen - 1) {  // we're at the end of the list
                            if (mRepeatMode == REPEAT_NONE) {
                                if (mSession != null) {
                                    deactivateMediaSession();
                                }
                                gotoIdleState();
                                notifyChange(PLAYSTATE_CHANGED);
                                break;
                            } else {
                                mPlayPos = 0;
                            }
                        } else {
                            mPlayPos++;
                        }

                        if (mPlayers[mCurrentPlayer].isInitialized()) {
                            mPlayers[mCurrentPlayer].stop();
                        }

                        swapPlayers();

                        if (!mPlayers[mCurrentPlayer].isInitialized()) {
                            while (!prepare(mPlayList[mPlayPos])) {
                                if (mPlayPos >= mPlayListLen - 1) { // we're at the end of the list
                                    Toast.makeText(this, R.string.playback_failed, Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    mPlayPos++;
                                }
                            }
                        }

                        if (!mPlayers[mCurrentPlayer].isPlaying()) {
                            if (fadeSeconds > 0) {
                                mCurrentVolume[mCurrentPlayer] = 0f;
                                mPlayers[mCurrentPlayer].setVolume(mCurrentVolume[mCurrentPlayer]);
                            }
                            Log.d(TAG, "Starting playback");
                            mPlayers[mCurrentPlayer].start();

                            mPlaybackHander.sendMessage(mPlaybackHander.obtainMessage(FADEUP, mCurrentPlayer, 0));
                        }

                        fetchMetadata(mPlayList[mPlayPos]);
                        startForeground(PLAYBACKSERVICE_STATUS, buildNotification());
                        notifyChange(META_CHANGED);
                        break;
                }
                break;
        }
    }

