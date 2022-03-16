    private void listenForRequests() {
        try {
            while (true) {
                Connection requestCon = server.listen();
                if (requestCon == null) {
                    break; //null would mean close() was called
                }

                try {
                    String receiverAddress = requestCon.getNextString();

                    RequestHandler requestHandler = new RequestHandler(requestCon, receiverAddress);
                    new Thread(requestHandler, THREAD_REQUEST_HANDLER + session++).start();
                } catch (IOException e) {/*TODO: handle if required*/}
            }

        } catch (IOException e) {
            //TODO: handle this
        }
    }

