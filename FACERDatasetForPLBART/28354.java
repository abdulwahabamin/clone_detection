	/**
	 * Set the above view content from a layout resource. The resource will be inflated, adding all top-level views
	 * to the above view.
	 *
	 * @param res the new content
	 */
	public void setContent(int res) {
		setContent(LayoutInflater.from(getContext()).inflate(res, null));
	}

