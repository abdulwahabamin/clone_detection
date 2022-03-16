	/**
	 * Typical usage:
	 * Put this code in the beginning of onCreate().
	 * <pre>
	 * if (DistributionLibrary.showEulaOrNewVersion(this)) {
            return;
       }
	 * </pre>
	 * 
	 * If one of the two activities is shown, they make
	 * sure that the calling intent is called again afterwards.
	 * 
	 * @param activity
	 * @return true if one of the dialogs is being shown.
	 *         In this case, onCreate() should be aborted by
	 *         returning.
	 */
	public boolean showEulaOrNewVersion() {
		return EulaOrNewVersion.showEula(mActivity) 
			|| EulaOrNewVersion.showNewVersion(mActivity);
	}

