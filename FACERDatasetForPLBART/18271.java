    public static ArrayList<Object> extractFileMetadata(String filePath) {
    	ArrayList<Object> metadata = new ArrayList<Object>();
    	
    	MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    	mediaMetadataRetriever.setDataSource(filePath);
    	
    	metadata.add(mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
    	metadata.add(mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
    	metadata.add(mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
    	metadata.add(mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
    	metadata.add(mediaMetadataRetriever.getEmbeddedPicture());
    	
    	return metadata;
    	
    }

