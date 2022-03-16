    @Override
    public void updateItem(ShareData data, int position) {
        mShareData = data;
        mShareIcon.setImageResource(SHARE_ICONS[position]);
        mShareTip.setText(TIPS[position]);
        mPosition = position;
    }

