    @Override
    protected void onPreExecute() {
        if (mBuildLibraryProgressUpdate!=null)
            for (int i=0; i < mBuildLibraryProgressUpdate.size(); i++)
                if (mBuildLibraryProgressUpdate.get(i)!=null)
                    mBuildLibraryProgressUpdate.get(i).onStartBuildingLibrary();
    }

