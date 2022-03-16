	public static Typeface getTypeface(Context context, String fileName) {
		Typeface tempTypeface = sTypeFaces.get(fileName);
		
		if (tempTypeface==null) {
		    String fontPath = new StringBuilder(TYPEFACE_FOLDER).append('/')
		    													.append(fileName)
		    													.append(TYPEFACE_EXTENSION)
		    													.toString();
		    
		    tempTypeface = Typeface.createFromAsset(context.getAssets(), fontPath);
		    sTypeFaces.put(fileName, tempTypeface);
		}
		
		return tempTypeface;
	}

