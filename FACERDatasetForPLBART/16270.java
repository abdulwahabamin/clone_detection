    @SuppressLint("HandlerLeak")
    private void initView() {
        register();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:
                        musicService.pausePlay();
                        break;
                    case 1:
                        if (musicService.isPlay()) {
                            musicService.prevMusic();
                        }
                        break;
                    case 2:
                        if (musicService.isPlay()) {
                            musicService.nextMusic();
                        }
                        break;
                    case 3:
                        MainActivity activity = (MainActivity) getActivity();
                        activity.showFragment(1);
                        break;
                    case 4:
                        musicService.pausePlay();
                        break;
                    default:
                        break;
                }
            }
        };
    }

