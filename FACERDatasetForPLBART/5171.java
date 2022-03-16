	public static void compress(Activity activity,String folderPath) {
		
		
		   //final int BUFFER = 1024;
		   //final String ps=pipe;
		         BufferedInputStream origin = null;
		         
		         File zipFolder = new File(folderPath);
		         
		         File zipFile = new File(zipFolder.getAbsolutePath()+"/../"+zipFolder.getName()+".zip");
		      try {

		         if(!zipFile.exists())  {
		             zipFile.createNewFile();
		         }
		         //BLog.e("ZIPDIR",zipFile.getAbsolutePath());
		         
		         FileOutputStream dest = new FileOutputStream(zipFile.getAbsolutePath());
		         ZipOutputStream zout = new ZipOutputStream(new BufferedOutputStream(dest));
		         //out.setMethod(ZipOutputStream.DEFLATED);
		         
		         //byte data[] = new byte[BUFFER];

		         addDirectory(zout,zipFolder);
		         
		         zout.close();
		         
		         //FileManager.refresh(activity);
		      } catch(Exception e) {
		    	  //BLog.add("ZIPDIR:E:"+zipFile.getAbsolutePath(),e);
		      }
	}

