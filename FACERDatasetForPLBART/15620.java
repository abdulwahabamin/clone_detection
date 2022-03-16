    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	if(item.getGroupId()==mFragmentGroupId){
	        switch (item.getItemId()) {
	            case PLAY_SELECTION:
	                long[] list = MusicUtils.getSongListForGenre(getActivity(),
	                        										Long.parseLong(mCurrentId));
	                MusicUtils.playAll(getActivity(), list, 0);
	                break;
	            default:
	                break;
	        }
	        return true;
	    }
        return super.onContextItemSelected(item);
    }

