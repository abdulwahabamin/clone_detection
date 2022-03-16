        void handleRequest(int action)throws IOException {
            String requestType = con.getNextString();
            Object responseData;

            switch (requestType) {
                case DATA_TYPE_NULL:
                    responseData =
                            requestListener.onNewRequest(senderDeviceAddress, action, null);
                    break;
                case DATA_TYPE_STRING:
                    responseData = requestListener.onNewRequest(senderDeviceAddress, action,
                            con.getNextString());
                    break;
                case DATA_TYPE_INTEGER:
                    responseData = requestListener.onNewRequest(senderDeviceAddress, action,
                            con.getNextInt());
                    break;
                case DATA_TYPE_LONG:
                    responseData = requestListener.onNewRequest(senderDeviceAddress, action,
                            con.getNextLong());
                    break;
                case DATA_TYPE_FILE:
                    int size = con.getNextInt();
                    responseData = requestListener.onNewRequest(senderDeviceAddress, action,
                            con.getNextFile(getCacheDir()+"/files",size));
                    break;
                default:
                    responseData = requestListener.onNewRequest(senderDeviceAddress, action,
                            con.getNextObject());
                    break;
            }

            if(responseData == null) {
                con.sendString(DATA_TYPE_NULL);
            } else if(responseData instanceof String) {
                con.sendString(DATA_TYPE_STRING);
                con.sendString((String) responseData);
            } else if(responseData instanceof Integer) {
                con.sendString(DATA_TYPE_INTEGER);
                con.sendInt((Integer) responseData);
            } else if(responseData instanceof Long) {
                con.sendString(DATA_TYPE_INTEGER);
                con.sendLong((Long) responseData);
            } else if(responseData instanceof File) {
                con.sendString(DATA_TYPE_FILE);
                int size = (int) (((File) responseData).length());
                con.sendInt(size);
                con.sendFile((File) responseData);
            } else {
                con.sendString(DATA_TYPE_OBJECT);
                con.sendObject(responseData);
            }

            con.close();
        }

