    void sendFile(File file) throws IOException {
        FileInputStream fin = new FileInputStream(file);
        byte[] buffer = new byte[8096];
        DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
        int count;

        readyWait(TransmissionType.WRITE);
        while ((count = fin.read(buffer, 0, buffer.length)) > 0) {
            dataOut.write(buffer, 0, count);
        }

        fin.close();
    }

