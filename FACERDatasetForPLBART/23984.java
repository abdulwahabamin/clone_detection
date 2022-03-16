        @Override
        public void handleMessage(Message msg) {
            int fadeSeconds = Integer.parseInt(mSettings.getString(SettingsActivity.FADE_SECONDS, "0"));

            switch (msg.what) {
                case DUCK:
                    // Log.v(TAG, "handleMessage DUCK: " + msg.arg1);
                    mCurrentVolume[msg.arg1] -= .05f;
                    if (mCurrentVolume[msg.arg1] > .2f) {
                        mPlaybackHander.sendMessageDelayed(mPlaybackHander.obtainMessage(DUCK, msg.arg1, 0), 10);
                    } else {
                        mCurrentVolume[msg.arg1] = .2f;
                    }
                    mPlayers[msg.arg1].setVolume(mCurrentVolume[msg.arg1]);
                    break;

                case FADEDOWN:
                    // Log.v(TAG, "handleMessage FADEDOWN: " + msg.arg1);
                    mCurrentVolume[msg.arg1] -= .01f / Math.max(fadeSeconds, 1);
                    if (mCurrentVolume[msg.arg1] > 0.0f) {
                        mPlaybackHander.sendMessageDelayed(mPlaybackHander.obtainMessage(FADEDOWN, msg.arg1, 0), 10);
                    } else {
                        mCurrentVolume[msg.arg1] = 0.0f;
                    }
                    mPlayers[msg.arg1].setVolume(mCurrentVolume[msg.arg1]);
                    break;

                case FADEUP:
                    // Log.v(TAG, "handleMessage FADEUP: " + msg.arg1);
                    mCurrentVolume[msg.arg1] += .01f / Math.max(fadeSeconds, 1);
                    if (mCurrentVolume[msg.arg1] < 1.0f) {
                        mPlaybackHander.sendMessageDelayed(mPlaybackHander.obtainMessage(FADEUP, msg.arg1, 0), 10);
                    } else {
                        mCurrentVolume[msg.arg1] = 1.0f;
                        scheduleFadeOut();
                    }
                    mPlayers[msg.arg1].setVolume(mCurrentVolume[msg.arg1]);
                    break;

                case FOCUSCHANGE:
                    // This code is here so we can better synchronize it with the code that handles fade-in
                    switch (msg.arg1) {
                        case AudioManager.AUDIOFOCUS_LOSS:
                            Log.d(TAG, "AudioFocus: received AUDIOFOCUS_LOSS");
                            audioFocusLoss();
                            mAudioManager.abandonAudioFocus(mAudioFocusListener);
                            pause();
                            if (mSession != null) {
                                deactivateMediaSession();
                            }
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                            Log.d(TAG, "AudioFocus: received AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                            mPlaybackHander.removeMessages(FADEUP);
                            mPlaybackHander.removeMessages(FADEDOWN);
                            mPlaybackHander.removeMessages(CROSSFADE);
                            mPlaybackHander.sendMessage(mPlaybackHander.obtainMessage(DUCK, mCurrentPlayer, 0));
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                            Log.d(TAG, "AudioFocus: received AUDIOFOCUS_LOSS_TRANSIENT");
                            boolean wasPlaying = isPlaying();
                            pause();
                            if (wasPlaying) {
                                mPausedByTransientLossOfFocus = true;
                            }
                            break;
                        case AudioManager.AUDIOFOCUS_GAIN:
                            Log.d(TAG, "AudioFocus: received AUDIOFOCUS_GAIN");
                            audioFocusGain();
                            if (mSession != null) {
                                activateMediaSession();
                            }

                            if (!isPlaying() && mPausedByTransientLossOfFocus) {
                                mPausedByTransientLossOfFocus = false;
                                mCurrentVolume[mCurrentPlayer] = 0f;
                                mPlayers[mCurrentPlayer].setVolume(mCurrentVolume[mCurrentPlayer]);
                                play(); // also queues a fade-in
                            } else if (isPlaying()) {
                                mPlaybackHander.removeMessages(DUCK);
                                mPlaybackHander.removeMessages(FADEDOWN);
                                mPlaybackHander.removeMessages(CROSSFADE);
                                mPlaybackHander.sendMessage(mPlaybackHander.obtainMessage(FADEUP, mCurrentPlayer, 0));
                            }
                            break;
                        default:
                            Log.w(TAG, "Unknown audio focus change code: " + msg.arg1);
                    }
                    break;

                case CROSSFADE:
                    Log.d(TAG, "handleMessage CROSSFADE");
                    if (!mPlayers[mNextPlayer].isInitialized()) {
                        if ((mRepeatMode == REPEAT_NONE || mRepeatMode == REPEAT_ALL) && (mPlayPos + 1) < mPlayListLen) {
                            long nextId = mPlayList[mPlayPos + 1];
                            Log.d(TAG, "Preparing next song " + nextId);
                            mPlayers[mNextPlayer].prepare(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI + "/" + String.valueOf(nextId));
                        }
                    }
                    if (mPlayers[mNextPlayer].isInitialized()) {
                        if (fadeSeconds > 0) {
                            mCurrentVolume[mNextPlayer] = 0f;
                            mPlayers[mNextPlayer].setVolume(mCurrentVolume[mNextPlayer]);
                        }
                        Log.d(TAG, "Cross-fading");
                        mPlayers[mNextPlayer].start();

                        mPlaybackHander.sendMessage(mPlaybackHander.obtainMessage(FADEUP, mNextPlayer, 0));

                        notifyChange(META_CHANGED);
                    }

                    break;
            }
        }

