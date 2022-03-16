    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item:
                mClickListener.onItemClick(v, v.getTag());
                break;
            case R.id.ll_praise_container:
                ImageWeather imageWeather = (ImageWeather) v.getTag();
                praise(v, imageWeather);
                break;
        }
    }

