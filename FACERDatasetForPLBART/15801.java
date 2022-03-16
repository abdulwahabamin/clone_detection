    File getNextFile(String filePath, int size)throws IOException {
        File file = new File(filePath);
        if(file.exists()) {
            file.delete();
        }
        file.createNewFile();

        int count;
        DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
        FileOutputStream fileOut = new FileOutputStream(file);
        byte[] buffer = new byte[8096];

        readyWait(TransmissionType.READ);

        for(;size > 0; size -= count) {
            count = dataIn.read(buffer,0,buffer.length);
            fileOut.write(buffer, 0, count);
        }

        fileOut.close();

        return file;
    }

