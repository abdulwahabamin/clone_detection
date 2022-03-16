    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_set:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.iv_add_city:
                startActivity(new Intent(this, SearchActivity.class));
                break;
        }
    }

