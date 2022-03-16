	private static void addDirectory(ZipOutputStream zout, File fileSource) {
	       
        //get sub-folder/files list
        File[] files = fileSource.listFiles();
       
        //System.out.println("Adding directory " + fileSource.getName());
       
        for(int i=0; i < files.length; i++)
        {
                //if the file is directory, call the function recursively
                if(files[i].isDirectory())
                {
                        addDirectory(zout, files[i]);
                        continue;
                }
               
                /*
                 * we are here means, its file and not directory, so
                 * add it to the zip file
                 */
               
                try
                {
                        //System.out.println("Adding file " + files[i].getName());
                       
                        //create byte buffer
                        byte[] buffer = new byte[1024];
                       
                        //create object of FileInputStream
                        FileInputStream fin = new FileInputStream(files[i]);
                       
                        zout.putNextEntry(new ZipEntry(files[i].getName()));
                 
                        /*
                         * After creating entry in the zip file, actually
                         * write the file.
                         */
                        int length;
                 
                        while((length = fin.read(buffer)) > 0)
                        {
                           zout.write(buffer, 0, length);
                        }
                 
                        /*
                         * After writing the file to ZipOutputStream, use
                         *
                         * void closeEntry() method of ZipOutputStream class to
                         * close the current entry and position the stream to
                         * write the next entry.
                         */
                 
                         zout.closeEntry();
                 
                         //close the InputStream
                         fin.close();
               
                }
                catch(IOException ioe)
                {
                        //BLog.add("ZIP IOException :" + ioe);
                }
        }
       
	}

