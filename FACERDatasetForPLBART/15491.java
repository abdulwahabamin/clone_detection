    @Override
    public void drop(int from, int to) {
    	super.drop(from, to);
        if (from != to && mPlaylistId >= 0) {
        	try{
                Playlists.Members.moveItem(mContext.getContentResolver(),mPlaylistId, from, to);
            }catch(Exception e){
                Log.e("FAILED", e.getMessage());
            }
        }
    }

