    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	if( item.getGroupId() == mFragmentGroupId ){
	        switch (item.getItemId()) {
	            case PLAY_SELECTION:
	                int position = mSelectedPosition;
	                MusicUtils.playAll(getActivity(), mCursor, position);
	                break;
	            case ADD_TO_PLAYLIST: {
	                Intent intent = new Intent(INTENT_ADD_TO_PLAYLIST);
	                long[] list = new long[] {
	                    mSelectedId
	                };
	                intent.putExtra(INTENT_PLAYLIST_LIST, list);
	                getActivity().startActivity(intent);
	                break;
	            }
	            case USE_AS_RINGTONE:
	                MusicUtils.setRingtone(getActivity(), mSelectedId);
	                break;
	            case SEARCH: {
	                MusicUtils.doSearch(getActivity(), mCursor, mType);
	                break;
	            }
	            case REMOVE: {
	                removePlaylistItem(mSelectedPosition);
	                break;
	            }
	            default:
	                break;
	        }
	        return true;
    	}
        return super.onContextItemSelected(item);
    }

