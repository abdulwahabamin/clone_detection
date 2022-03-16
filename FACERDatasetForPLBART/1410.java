    /**
     * Sends the selected file to the Peripheral device
     * @param data
     */
    private void sendFile(Intent data){
        Uri uri = data.getData();
        BLECentralHelper.getInstance().sendFile(uri);
    }

