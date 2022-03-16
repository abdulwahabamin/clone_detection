    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add:
                startActivityForResult(new Intent(this, AddCityActivity.class), RequestCode.REQUEST_CODE);
                break;
        }
    }

