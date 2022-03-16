	/**
	 * Remove the action icon from the given index (0 based)
	 * 
	 * @param index
	 * @return <code>true</code> if the item was removed
	 */
	public boolean removeActionIconAt(int index) {
		int count = mActionIconContainer.getChildCount();
		if (count > 0 && index >= 0 && index < count) {
			mActionIconContainer.removeViewAt(index);
			return true;
		}
		return false;
	}

