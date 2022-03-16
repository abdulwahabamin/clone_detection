    @OnClick({R.id.iv_ok, R.id.iv_prev, R.id.iv_next, R.id.iv_menu, R.id.iv_play})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_ok:
                EventBus.getDefault().post(new OkEvent());
                break;
            case R.id.iv_prev:
                EventBus.getDefault().post(new PrevEvent());
                break;
            case R.id.iv_next:
                EventBus.getDefault().post(new NextEvent());
                break;
            case R.id.iv_menu:
                EventBus.getDefault().post(new MenuEvent());
                break;
            case R.id.iv_play:
                EventBus.getDefault().post(new PlayEvent());
                break;
            default:
                break;
        }
    }

