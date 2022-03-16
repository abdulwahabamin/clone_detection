	/**
     * Return the Drawable that is associated with a specific mime type
     * for the VIEW action.
     * 
     * @param mimetype
     * @return
     */
    Drawable getDrawableForMimetype(File file, String mimetype) {
     if (mimetype == null) {
    	 return null;
     }
     
   	 PackageManager pm = context.getPackageManager();
   	 
   	 // Returns the icon packaged in files with the .apk MIME type.
   	 if(mimetype.equals(MIME_APK)){
   		 String path = file.getPath();
   		 PackageInfo pInfo = pm.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES);
   		 if (pInfo!=null) {
	   		 ApplicationInfo aInfo = pInfo.applicationInfo;
	   		 
	   		 // Bug in SDK versions >= 8. See here: http://code.google.com/p/android/issues/detail?id=9151
	   		 if(Build.VERSION.SDK_INT >= 8){
	   			 aInfo.sourceDir = path;
	   			 aInfo.publicSourceDir = path;
	   		 }
	   		 
	   		 return aInfo.loadIcon(pm);
   		 }
   	 }
   	 
   	 int iconResource = mMimeTypes.getIcon(mimetype);
   	 Drawable ret = null;
   	 if(iconResource > 0){
   		 try {
   			 ret = pm.getResourcesForApplication(context.getPackageName()).getDrawable(iconResource);
   		 }catch(NotFoundException e){}
   		 catch(NameNotFoundException e){}
   	 }
   	 
   	 if(ret != null){
   		 return ret;
   	 }
   	 
   	 Uri data = FileUtils.getUri(file);
   	
   	 Intent intent = new Intent(Intent.ACTION_VIEW);
   	 //intent.setType(mimetype);
   	 
   	 // Let's probe the intent exactly in the same way as the VIEW action
   	 // is performed in FileManagerActivity.openFile(..)
     intent.setDataAndType(data, mimetype);
     
   	 final List<ResolveInfo> lri = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
   	 
   	 if (lri != null && lri.size() > 0) {
   		 //Log.i(TAG, "lri.size()" + lri.size());
   		 
   		 // return first element
   		 int index = 0;
   		 
   		 // Actually first element should be "best match",
   		 // but it seems that more recently installed applications
   		 // could be even better match.
   		 index = lri.size()-1;
   		 
   		 final ResolveInfo ri = lri.get(index);
   		 return ri.loadIcon(pm);
   	 }
   	 
   	 return null;
    }

