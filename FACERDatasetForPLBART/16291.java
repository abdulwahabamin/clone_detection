    private void initView() {
        activity = (MainActivity) getActivity();
        ArrayList<HashMap<String, Object>> maps = initData();
        new LinearSnapHelper().attachToRecyclerView(optionRvMenu);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        optionRvMenu.setLayoutManager(layoutManager);
        OptionRvAdapter adapter = new OptionRvAdapter(getContext(), maps);
        optionRvMenu.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

        register();

        //如果在播放直接到播放
        if (musicService.isPlay()) activity.showFragment(4);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0: //Ok
                        itemClick(selPosition);
                        break;
                    case 1: //上一个
                        optionRvMenu.smoothScrollToPosition(0);
                        selPosition = 0;
                        break;
                    case 2: //下一个
                        optionRvMenu.smoothScrollToPosition(1);
                        selPosition = 1;
                        break;
                    case 3:
                        activity.showFragment(1);
                        break;
                    case 4:
                        musicService.pausePlay();
                        break;
                }
            }
        };
    }

