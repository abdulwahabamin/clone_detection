	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
        if(id == android.R.id.home){
        	onBackPressed();
        	return true;
        }
		return super.onOptionsItemSelected(item);
	}
