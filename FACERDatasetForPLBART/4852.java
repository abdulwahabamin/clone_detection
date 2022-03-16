	public static Drawable getFileIcon(Context context, String fileOrFilePath) {
		if(fileOrFilePath!=null) {
            fileOrFilePath=removeBriefFileExtension(fileOrFilePath);
			int extp=fileOrFilePath.lastIndexOf(".");
			if(extp>0) {
				String ext=fileOrFilePath.substring(extp);
				//BLog.e("GEEXT", ext);
				Integer Rval = IMG_FILES.get(ext.toLowerCase(Locale.getDefault()));
				if(Rval!=null) {
					Drawable d=context.getResources().getDrawable(Rval.intValue());
					if(d!=null)
						return d;
				}
			} else {
				return context.getResources().getDrawable(F_DIR);
			}
		}
		return context.getResources().getDrawable(F_NO);
	}

