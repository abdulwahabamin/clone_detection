    @Override
    protected InputStream getStreamFromOtherSource(String imageUri, Object extra) throws IOException {
        if (imageUri.startsWith(DB_URI_PREFIX)) {
        	
            String path = imageUri.substring(DB_URI_PREFIX.length());
            MediaMetadataRetriever mmdr = new MediaMetadataRetriever();
            byte[] imageData = null;
            try {
            	mmdr.setDataSource(path);
                imageData = mmdr.getEmbeddedPicture();
            } catch (Exception e) {
            	return super.getStreamFromOtherSource(imageUri, extra);
            }
            		
            return new ByteArrayInputStream(imageData);
        } else if (imageUri.startsWith(SCHEME_FILE)) { 
        	return new FileInputStream(imageUri);
    	} else {
            return super.getStreamFromOtherSource(imageUri, extra);
        }
        
    }

