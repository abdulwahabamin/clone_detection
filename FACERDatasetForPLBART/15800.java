    Object getNextObject()throws IOException {
        readyWait(TransmissionType.READ);
        ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
        try {
            return input.readObject();
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

