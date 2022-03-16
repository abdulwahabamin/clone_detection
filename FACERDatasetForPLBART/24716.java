    @Override
    protected void onPostExecute(ArrayList<MediaItem> mediaItems) {
        PlayerConstants.SONGS_LIST=mediaItems;

        //PlayerConstants.SONGSLOADING_HANDLER.sendMessage(PlayerConstants.SONGSLOADING_HANDLER.obtainMessage(0, "Complete"));
        if (mBuildLibraryProgressUpdate!=null)
            for (int i=0; i < mBuildLibraryProgressUpdate.size(); i++)
                if (mBuildLibraryProgressUpdate.get(i)!=null)
                    mBuildLibraryProgressUpdate.get(i).onFinishBuildingLibrary(this);
    }

