    public String getLargestImage() {
    	Set<ImageSize> sizes = availableSizes();
    	if(sizes.contains(ImageSize.MEGA))
        	return getImageURL(ImageSize.MEGA);
        else if(sizes.contains(ImageSize.EXTRALARGE))
        	return getImageURL(ImageSize.EXTRALARGE);
        else if(sizes.contains(ImageSize.LARGE))
        	return getImageURL(ImageSize.LARGE);    	
        else if(sizes.contains(ImageSize.MEDIUM))
        	return getImageURL(ImageSize.MEDIUM);  
        else
        	return getImageURL(ImageSize.LARGE);
    }

