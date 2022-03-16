    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
            KeyEvent event = intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            
            if (event == null) {
                return;
            }

            Log.d(LOGTAG, "Button: " + event.toString());

            // single quick press: pause/resume.
            // double press: next track

            String action = null;
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_MEDIA_PLAY:
                    action = nu.staldal.djdplayer.MediaPlaybackService.PLAY_ACTION;
                    break;
                case KeyEvent.KEYCODE_MEDIA_PAUSE:
                    action = nu.staldal.djdplayer.MediaPlaybackService.PAUSE_ACTION;
                    break;
                case KeyEvent.KEYCODE_MEDIA_STOP:
                    action = nu.staldal.djdplayer.MediaPlaybackService.STOP_ACTION;
                    break;
                case KeyEvent.KEYCODE_HEADSETHOOK:
                case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
                    action = nu.staldal.djdplayer.MediaPlaybackService.TOGGLEPAUSE_ACTION;
                    break;
                case KeyEvent.KEYCODE_MEDIA_NEXT:
                    action = nu.staldal.djdplayer.MediaPlaybackService.NEXT_ACTION;
                    break;
                case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
                    action = nu.staldal.djdplayer.MediaPlaybackService.PREVIOUS_ACTION;
                    break;
            }

            if (action != null) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (!mDown) {
                        // if this isn't a repeat event

                        // The service may or may not be running, but we need to send it a command.
                        Intent i = new Intent(context, MobileMediaPlaybackService.class);
                        if (event.getKeyCode() == KeyEvent.KEYCODE_HEADSETHOOK && event.getEventTime() - mLastClickTime < 300) {
                            action = nu.staldal.djdplayer.MediaPlaybackService.NEXT_ACTION;
                            mLastClickTime = 0;
                        } else {
                            mLastClickTime = event.getEventTime();
                        }
                        i.setAction(action);
                        context.startService(i);

                        mDown = true;
                    }
                } else {
                    mDown = false;
                }
                if (isOrderedBroadcast()) {
                    abortBroadcast();
                }
            }
        }
    }

