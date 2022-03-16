    private void initView() {
        songs = MusicUtil.getAllMusics(getContext());
       adapter = new MusicListAdapter(getContext(), songs);
        musicListView.setAdapter(adapter);
        musicListView.setOnItemClickListener(this);
        musicListView.setEmptyView(musicLlEmpty);

        register();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:
                        if (songs.size() > 0)
                            playClick(selPosition);
                        break;
                    case 1:
                        if (selPosition > 0 && selPosition <= songs.size())
                            moveTo(selPosition--);
                        break;
                    case 2:
                        if (selPosition >= 0 && selPosition < songs.size())
                            moveTo(selPosition++);
                        break;
                    case 3:
                        MainActivity activity = (MainActivity) getActivity();
                        activity.showFragment(1);
                        break;
                    case 4:
                        musicService.pausePlay();
                        break;
                }
            }
        };
    }

