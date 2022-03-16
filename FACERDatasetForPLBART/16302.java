    private void initView() {
        musicService = RairApp.getApp().getService();
        playSbProgress.setOnSeekBarChangeListener(this);

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
                        musicService.prevMusic();
                        break;
                    case 2:
                        musicService.nextMusic();
                        break;
                    case 3:
                        MainActivity activity = (MainActivity) getActivity();
                        activity.showFragment(2);
                        break;
                    case 4:
                        musicService.pausePlay();
                        break;
                    case 5:
                        int currentPrev = musicService.getCurrent();
                        musicService.movePlay(currentPrev - 2000);
                        break;
                    case 6:
                        int currentNext = musicService.getCurrent();
                        musicService.movePlay(currentNext + 2000);
                        break;
                }
            }
        };
        handler.post(updateThread);
    }

