    private void removeCurrentCounty() {
        if (mCountyList.size() == 0) {
            return;
        }

        final int position = mVpMain.getCurrentItem();
        final County county = mCountyList.get(position);
        if (county != null) {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.remove_county))
                    .setMessage(String.format(getString(R.string.remove_county_msg), county.getName()))
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SharedPrefsHelper helper = new SharedPrefsHelper(MainActivity.this);
                            helper.removeCounty(county);
                            WeatherInfoDAO dao = new WeatherInfoDAO(MainActivity.this);
                            dao.delete(county);
                            dao.close();
                            mCountyList.remove(position);
                            refreshViewPager();
                        }
                    })
                    .show();
        }
    }

