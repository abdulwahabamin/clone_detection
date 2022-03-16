	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//BLog.e("onOptionsItemSelected");
		switch(item.getItemId()) {

            case R.id.file_explore_archive_extract:
				mode=1;
				amb.done();
				refresh();
				return true;
		}
		return false;
	}

