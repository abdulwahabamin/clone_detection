    public void iterateThruFolder(String path, String operation) {

    	File root = null;
    	File[] list = null;
    	try {
            root = new File(path);
            list = root.listFiles();
    	} catch (Exception e) {
    		e.printStackTrace();
    	} catch (StackOverflowError e2) {
    		//The recursive function call is too damn long. Just quit at this point.
    		return;
    	}
    	
        if (list==null) {
        	return;
        }

        for (File f : list) {
        	
            if (f.isDirectory()) {
            	
            	//Update the progress dialog message.
            	try {
					publishProgress(new String[] { f.getCanonicalPath() });
				} catch (Exception e) {
					//Don't do anything.
				}
            	
            	if (operation.equals("ADD")) {
                    try {
						iterateThruFolder(f.getCanonicalPath(), "ADD");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    
                    try {
                    	String canonicalPath = f.getCanonicalPath();
						if (!mTempSelectedFolderPaths.contains(canonicalPath)) {
							mTempSelectedFolderPaths.add(canonicalPath);
							mTempSelectedFolderTimestamps.add("" + f.lastModified());
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
            	} else if (operation.equals("REMOVE")) {
            		
                    try {
						iterateThruFolder(f.getCanonicalPath(), "REMOVE");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    
                    try {
                    	String canonicalPath = f.getCanonicalPath();
						if (mTempSelectedFolderPaths.contains(canonicalPath)) {
							mTempSelectedFolderPaths.remove(canonicalPath);
							mTempSelectedFolderTimestamps.remove("" + f.lastModified());
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
            	}

            }
            
        }
        
    }

