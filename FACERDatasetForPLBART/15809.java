    void readyWait(TransmissionType nextTransmission) throws IOException {
        if(nextTransmission == TransmissionType.READ
                && lastTransmission == TransmissionType.READ) {
            new PrintWriter(clientSocket.getOutputStream(), true).println("ready");
        } else if(nextTransmission == TransmissionType.WRITE
                && lastTransmission == TransmissionType.WRITE) {
            new BufferedReader(new InputStreamReader(clientSocket.getInputStream())).readLine();
        }

        lastTransmission = nextTransmission;
    }

