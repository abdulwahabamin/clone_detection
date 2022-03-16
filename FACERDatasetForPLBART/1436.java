    /**
     * Saves the data byte array into a file
     */
    private void save2File(byte [] data){
        File filepath = Environment.getExternalStorageDirectory();
        String filePathName = filepath.getAbsolutePath() + "/BluetoothBLEChat/";
        // Create a new folder in SD Card
        File dir = new File(filePathName);
        dir.mkdirs();
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePathName + "data.jpg"));
            bos.write(data);
            bos.flush();
            bos.close();
        }catch (FileNotFoundException ex){
            showInfo(ex.toString());
        }catch (IOException ex){
            showInfo(ex.toString());
        }finally {
            BLEPeripheralHelper.getInstance().stopRfcommService();
        }
    }

