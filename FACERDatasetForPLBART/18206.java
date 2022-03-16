    @Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
		
    	pd.dismiss();
    	if (result==true) {
            if (mShouldMove)
        	    Toast.makeText(mContext, R.string.done_move, Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(mContext, R.string.done_copy, Toast.LENGTH_SHORT).show();
    	} else {
            if (mShouldMove)
        	    Toast.makeText(mContext, R.string.file_could_not_be_written_new_location, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(mContext, R.string.file_could_not_be_written_new_location, Toast.LENGTH_LONG).show();
    	}

        try {
            mFragment.refreshListView();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error er) {
            er.printStackTrace();
        }
		
	}

