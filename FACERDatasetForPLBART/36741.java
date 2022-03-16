    public void addCounty(View view) {
        String countyString = mCountyInput.getText().toString().trim();
        int position = mCountyStringList.indexOf(countyString);
        if (position < 0) {
            new AlertDialog.Builder(this)
                    .setMessage(R.string.dont_modify_selected_county)
                    .show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(KEY_SELECTED_COUNTY, mCountyList.get(position));
        setResult(RESULT_OK, intent);
        finish();
    }

