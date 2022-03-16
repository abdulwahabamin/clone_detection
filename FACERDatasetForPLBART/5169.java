    public static void compress(String zipfolder, String zipFilename, List<FileItem> files) {


        final int BUFFER = 1024;
        //final String ps=pipe;
        BufferedInputStream origin = null;

        File zipFolder = new File(zipfolder);

        File zipFile = new File(zipfolder+"/"+zipFilename);
        try {

                if(!zipFile.exists())  {
                        zipFile.createNewFile();
                }
                //BLog.e("ZIPDIR",zipFile.getAbsolutePath());

                FileOutputStream dest = new FileOutputStream(zipFile.getAbsolutePath());
                ZipOutputStream zout = new ZipOutputStream(new BufferedOutputStream(dest));
                //out.setMethod(ZipOutputStream.DEFLATED);

                //byte data[] = new byte[BUFFER];
                for(FileItem item: files) {
                    addFileItem(zout,item);
                }


                zout.close();

                //FileManager.refresh(activity);
        } catch(Exception e) {
                //BLog.add("ZIPDIR:E:"+zipFile.getAbsolutePath(),e);
        }
    }

