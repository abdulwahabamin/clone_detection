	public static File getImageFromGallery( Context context, ImageInfo imageInfo ){		
		String albumArt = ( imageInfo.type == TYPE_ALBUM ) ? imageInfo.data[3] : imageInfo.data[1];	  
        if(albumArt != null){
        	try{
        		File orgFile = new File(albumArt);
        		File newFile = new File(context.getExternalCacheDir(), createShortTag(imageInfo)+IMAGE_EXTENSION);
        		InputStream in = new FileInputStream(orgFile);
        		OutputStream out = new FileOutputStream(newFile);
        		byte[] buf = new byte[1024];
        		int len;
        		while ((len = in.read(buf)) > 0){
        			out.write(buf, 0, len);
        		}
        		in.close();
        		out.close();
	        	return newFile;
        	}
        	catch( Exception e){
        	}
        }
        return null;
	}

