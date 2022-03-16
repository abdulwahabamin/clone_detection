    @OnClick({R.id.main_iv_ok, R.id.main_iv_prev, R.id.main_iv_next, R.id.main_iv_menu, R.id.main_iv_play})
    public void onViewClicked(View view) {
        Intent intent = new Intent(Constants.ACTION_SEND);
        switch (view.getId()) {
            case R.id.main_iv_ok:
                intent.putExtra(Constants.ACTION_KEY, Constants.ACTION_OK);
                break;
            case R.id.main_iv_prev:
                intent.putExtra(Constants.ACTION_KEY, Constants.ACTION_PREV);
                break;
            case R.id.main_iv_next:
                intent.putExtra(Constants.ACTION_KEY, Constants.ACTION_NEXT);
                break;
            case R.id.main_iv_menu:
                intent.putExtra(Constants.ACTION_KEY, Constants.ACTION_MENU);
                break;
            case R.id.main_iv_play:
                intent.putExtra(Constants.ACTION_KEY, Constants.ACTION_PLAY);
                break;
            default:
                break;
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

