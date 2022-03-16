	/**
	 * Checks if we have AudioFocus. If not, it explicitly requests it.
	 * 
	 * @return True if we have AudioFocus. False, otherwise.
	 */
	private boolean checkAndRequestAudioFocus() {
		if (mAudioManagerHelper.hasAudioFocus()==false) {
			if (requestAudioFocus()==true) {
				return true;
			} else {
				//Unable to get focus. Notify the user.
				Toast.makeText(mContext, R.string.unable_to_get_audio_focus, Toast.LENGTH_LONG).show();
				return false;
			}
			
		} else {
			return true;
		}
		
	}

