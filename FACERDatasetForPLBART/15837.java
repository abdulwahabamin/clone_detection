        @Override
        public void run() {
            try {
                int action = con.getNextInt();

                if (action == ACTION_ESTABLISH) {
                    handler.executeAsync(new Runnable() {
                        @Override
                        public void run() {
                            incomingEstablishRequested(con, senderDeviceAddress);
                        }
                    }, THREAD_CLIENT_HANDLER);
                } else if (action == ACTION_NEW_CLIENT) {
                    handler.executeAsync(new Runnable() {
                        @Override
                        public void run() {
                            newClient(con);
                        }
                    }, THREAD_CLIENT_HANDLER);
                } else if(action == ACTION_CLIENT_LEFT) {
                    handler.executeAsync(new Runnable() {
                        @Override
                        public void run() {
                            clientLeftNotification(con);
                        }
                    }, THREAD_CLIENT_HANDLER);
                } else if(action == ACTION_PEACEOUT) {
                    handler.executeAsync(new Runnable() {
                        @Override
                        synchronized public void run() {
                            clientMap.remove(senderDeviceAddress);
                            if(senderDeviceAddress.equals(ownerDeviceAddress)) {
                                groupConnectionListener.onOwnerDisconnected();
                            } else {
                                groupMemberListener.onMemberLeft(senderDeviceAddress);
                            }
                            con.close();
                        }
                    }, THREAD_CLIENT_HANDLER);
                } else if(action == ACTION_RAW_SOCKET) {
                    requestListener.onNewRequest(senderDeviceAddress, ACTION_RAW_SOCKET,
                            con.getSocket());
                } else {
                    handleRequest(action);
                }
            } catch (IOException e) {
                //TODO: handle
            }
        }

