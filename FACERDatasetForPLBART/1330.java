    /**
     *
     */
    public void sendFile(final Uri uri){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                try{
                    InputStream is = mContext.getContentResolver().openInputStream(uri);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] b = new byte[1024];
                    int bytesRead = 0;
                    while ((bytesRead = is.read(b)) != -1) {
                        bos.write(b, 0, bytesRead);
                    }
                    send2Rfcomm(bos.toByteArray());
                }catch(FileNotFoundException ex){

                }catch(IOException ex){

                }
            }
        });
    }

