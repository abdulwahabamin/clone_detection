        @Override
        protected Boolean doInBackground(Boolean... params) {
            if(files!=null && !files.isEmpty()) {
                InputStream inStream = null;
                OutputStream outStream = null;
                for (FileItem file : files) {

                    try{

                        //File afile =new File("C:\\folderA\\Afile.txt");
                        File bfile =new File(Files.getAvailableIncrementedFilePath(pasteToPath+File.separator+file.getName()));
                        bfile.createNewFile();
                        inStream = new FileInputStream(file);
                        outStream = new FileOutputStream(bfile);

                        byte[] buffer = new byte[1024];

                        int length;
                        //copy the file content in bytes
                        while ((length = inStream.read(buffer)) > 0){

                            outStream.write(buffer, 0, length);

                        }

                        inStream.close();
                        outStream.close();

                    }catch(IOException e){
                        BLog.e("paste path: " + e.getMessage());
                    }
                }




            }
            //Indexer.refresh(SERVICE);


            return Boolean.TRUE;

        }

