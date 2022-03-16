    public void sendRequest(String deviceId, int action, Object requestData, ResponseListener responseListener) {
        Connection connection = null;

        try {
            connection = new Connection(clientMap.get(deviceId).inetAddress,
                    clientMap.get(deviceId).port);

            connection.sendString(p2pBroadcastReceiver.myDevice.deviceAddress);

            connection.sendInt(action);

            if(requestData == null) {
                connection.sendString(DATA_TYPE_NULL);
            } else if(requestData instanceof String) {
                connection.sendString(DATA_TYPE_STRING);
                connection.sendString((String) requestData);
            } else if(requestData instanceof Integer) {
                connection.sendString(DATA_TYPE_INTEGER);
                connection.sendInt((Integer) requestData);
            } else if(requestData instanceof Long) {
                connection.sendString(DATA_TYPE_LONG);
                connection.sendLong((Long) requestData);
            } else if (requestData instanceof File){
                connection.sendString(DATA_TYPE_FILE);
                long size = ((File) requestData).length();
                if(size > Integer.MAX_VALUE) throw new Exception("File too big");

                connection.sendInt((int) size);
                connection.sendFile((File) requestData);
            }else {
                connection.sendString(DATA_TYPE_OBJECT);
                connection.sendObject(requestData);
            }

            String responseType = connection.getNextString();

            switch (responseType) {
                case DATA_TYPE_NULL:
                    responseListener.onResponseReceived(null);
                    break;
                case DATA_TYPE_STRING:
                    responseListener.onResponseReceived(connection.getNextString());
                    break;
                case DATA_TYPE_INTEGER:
                    responseListener.onResponseReceived(connection.getNextInt());
                    break;
                case DATA_TYPE_LONG:
                    responseListener.onResponseReceived(connection.getNextLong());
                    break;
                case DATA_TYPE_FILE:
                    int size = connection.getNextInt();
                    if(size > (MAX_FILE_CACHE_SIZE_MB-fileCacheSize)) {
                        for(int i =0 ; i<cacheFileName
                                && size>MAX_FILE_CACHE_SIZE_MB-fileCacheSize; i++) {
                            File file = new File(Library.FILE_SAVE_LOCATION,
                                    String.valueOf(i));
                            if(file.exists()) {
                                fileCacheSize -= file.length();
                                file.delete();
                            }
                        }
                        if(size>(MAX_FILE_CACHE_SIZE_MB-fileCacheSize)) {
                            throw new Exception("File too big");
                        }
                    }
                    File file = connection.getNextFile(
                            Library.FILE_SAVE_LOCATION + "/" + cacheFileName++, size);
                    fileCacheSize+=size;
                    responseListener.onResponseReceived(file);
                    break;
                default:
                    responseListener.onResponseReceived(connection.getNextObject());
                    break;
            }

        } catch (IOException e) {
            responseListener.onRequestFailed();
        } catch (Exception e) {
            if(e.toString().equals("File too big"))
                responseListener.onRequestFailed();
        }finally {
            if (connection != null) connection.close();
        }
    }

