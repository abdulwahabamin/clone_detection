    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_add:
                Intent intent = AddActivity.getIntent(this);
                startActivityForResult(intent, REQUEST_CODE_ADD_COUNTY);
                break;
            case R.id.menu_item_remove:
                removeCurrentCounty();
                break;
            case R.id.menu_item_refresh:
                FetchWeatherInfoService.start(this);
                break;
//            case R.id.menu_item_settings:
//                break;
        }
        return true;
    }

