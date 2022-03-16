        @Override
        public void onReceive(Context context, Intent intent) {
            if (service == null) return;
            switch (intent.getAction()) {
                case MediaPlaybackService.META_CHANGED:
                    totalTime.setText(MusicUtils.formatDuration(getActivity(), service.duration()));
                    setPauseButtonImage();
                    queueNextRefresh(1);
                    break;
                case MediaPlaybackService.PLAYSTATE_CHANGED:
                    setPauseButtonImage();
                    break;
            }
        }

