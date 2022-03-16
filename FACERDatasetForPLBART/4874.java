	public static String getAvailableIncrementedFilePath(String requestedFileNameAndPath) {
		File f = new File(requestedFileNameAndPath);
		String path=f.getParentFile().getAbsolutePath();
		Files.ensurePath(path);
		if(!f.exists())
			return requestedFileNameAndPath;
		String newfilename=null;
		String []splits = f.getName().split("\\.");
		String fnle = splits[0];
		String fnler="";
		if(splits.length>1) {
			for(int i=1; i<splits.length;i++)
				fnler+="."+splits[i];
		}
        if(fnle.indexOf("-")!=-1) {
            String subfn = fnle.substring(0,fnle.lastIndexOf("-"));
            String co = fnle.substring(fnle.lastIndexOf("-")+1,fnle.length());
            //BLog.e("splitting name: "+co);
            if(Sf.toInt(co)>0)
                fnle=subfn;
        }
		//String ext = Files.getExtension(f.getName());
		for(int i=1; i<1000; i++) {
			f=new File(path+File.separator+fnle+"-"+i+fnler);
			if(!f.exists()) {
				break;
			}
		}
		//Log.e("FN","available name: "+f.getAbsolutePath());
		return f.getAbsolutePath();
	}

