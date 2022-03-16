    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onReceivedFetchCountyListResultCode(Integer resultCode) {
        L.v(TAG, "resultCode = " + resultCode);

        if (resultCode == FetchCountyListService.RESULT_OK) {
            mCountyInput.setText("");
            mCountyInput.setEnabled(true);
            mPbProgress.setVisibility(View.GONE);
            L.d(TAG, "Enabled input");

            CountyDAO dao = new CountyDAO(this);
            List<County> countyList = dao.queryAll();
            for (County county : countyList) {
                mCountyList.add(county);
                String string = county.getName() + ", " + county.getCity() + ", " + county.getProvince();
                mAdapter.add(string);
                mCountyStringList.add(string);
            }
        } else {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.load_failed))
                    .setMessage(getString(R.string.load_county_list_failed_msg))
                    .setCancelable(false)
                    .setPositiveButton(getString(R.string.i_know), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AddActivity.this.finish();
                        }
                    })
                    .show();
            L.d(TAG, "Load failed");
        }
    }

