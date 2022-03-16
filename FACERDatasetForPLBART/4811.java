	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//Log.e("OPTIONS", "onCreateOptionsMenu at new emai home");
        switch(item.getItemId()) {
            case R.id.open_edit:
				amb.done();
                Device.openAndroidFile(activity, new File(useFile));

                return true;
        }
        return false;
	}

