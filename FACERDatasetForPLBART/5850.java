	private void addMimeTypeStart() {
		String extension = mXpp.getAttributeValue(null, ATTR_EXTENSION);
		String mimetype = mXpp.getAttributeValue(null, ATTR_MIMETYPE);
		String icon = mXpp.getAttributeValue(null, ATTR_ICON);
		
		if(icon != null){
			int id = resources.getIdentifier(icon.substring(1) /* to cut the @ */, null, packagename);
			if(id > 0){
				mMimeTypes.put(extension, mimetype, id);
				return;
			}
		}
		
		mMimeTypes.put(extension, mimetype);
	}

