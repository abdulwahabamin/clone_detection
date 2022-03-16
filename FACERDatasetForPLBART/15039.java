	/**
	 * @return the text content of the element
	 */
	public String getText() {
		// XXX e.getTextContent() doesn't exsist under Android (Lukasz Wisniewski)
		/// getTextContent() is now available in at least Android 2.2 if not earlier, so we'll keep using that
		// return e.hasChildNodes() ? e.getFirstChild().getNodeValue() : null;
		return e.getTextContent();
	}

