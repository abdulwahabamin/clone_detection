    @Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
		
    	pd.dismiss();
    	if (result==true) {
            if (mSourceType==FilesFoldersFragment.FOLDER)
        	    Toast.makeText(mContext, R.string.folder_deleted, Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(mContext, R.string.file_deleted, Toast.LENGTH_SHORT).show();

    	} else {
            if (mSourceType==FilesFoldersFragment.FOLDER)
        	    Toast.makeText(mContext, R.string.folder_could_not_be_deleted, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(mContext, R.string.file_could_not_be_deleted, Toast.LENGTH_LONG).show();

    	}

        try {
            mFragment.refreshListView();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

