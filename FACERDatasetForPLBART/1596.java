    public void write(String str){
        try {
            outputStream.write(str.getBytes());
        } catch(IOException e){
            Log.d("CommsThread", e.getLocalizedMessage());
        }
    }

