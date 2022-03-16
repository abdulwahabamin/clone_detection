    @Override
    protected void onPostExecute(Void arg0) {
    	mActivity.finish();
    	Toast.makeText(mContext, R.string.done_creating_library, Toast.LENGTH_LONG).show();
       
    }

