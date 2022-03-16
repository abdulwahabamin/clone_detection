    String getNextString()throws IOException {
        readyWait(TransmissionType.READ);
        BufferedReader input = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        return input.readLine();
    }

