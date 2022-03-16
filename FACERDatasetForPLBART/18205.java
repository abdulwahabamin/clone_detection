    @Override
    protected Boolean doInBackground(String... params) {

        try {
            if (mSourceFile.getCanonicalPath()==mDestinationFile.getCanonicalPath()) {
                Toast.makeText(mContext, R.string.source_target_same, Toast.LENGTH_LONG).show();
                return false;
            }

        } catch (Exception e) {
            return false;
        }

    	if (mSourceFile.isDirectory()) {
    		
    		try {
                if (mShouldMove)
				    FileUtils.moveDirectoryToDirectory(mSourceFile, mDestinationFile, true);
                else
                    FileUtils.copyDirectoryToDirectory(mSourceFile, mDestinationFile);

			} catch (Exception e) {
				return false;
			}
    		
    	} else {
    		
    		try {
                if (mShouldMove)
    			    FileUtils.moveFileToDirectory(mSourceFile, mDestinationFile, true);
                else
                    FileUtils.copyFile(mSourceFile, mDestinationFile);

    		} catch (Exception e) {
    			return false;
    		}
    		
    	}

    	return true;
    }

