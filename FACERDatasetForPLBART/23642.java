        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(MediaPlaybackService.PLAYBACK_COMPLETE)) {
                // You would come here only in case of a failure in the
                // MediaPlayerService before PrepareAsync completes
                String msg = getString(R.string.fail_to_start_stream);
                Toast mt = Toast.makeText(StreamStarter.this, msg, Toast.LENGTH_SHORT);
                mt.show();
                finish();
                return;
            }
            try {
                MusicUtils.sService.play();
                intent = new Intent("com.android.music.PLAYBACK_VIEWER");
                intent.putExtra("oneshot", true);
                startActivity(intent);
            } catch (RemoteException ex) {
            }
            finish();
        }

