        public void run() {
            /* Esto es para envío de texto, no funciona para imagen

            byte[] buffer = new byte[1024];
            int bytes;

            // Keep listening to the InputStream
            while (true) {
                try {
                    // Read from the InputStream
                    bytes = inputStream.read(buffer);
                    // Send the obtained bytes to the UI Activity
                    handler.obtainMessage(MainActivity.MESSAGE_READ, bytes, -1,
                            buffer).sendToTarget();
                } catch (IOException e) {
                    connectionLost();
                    // Start the service over to restart listening mode
                    ChatController.this.start();
                    break;
                }
            }*/
            byte[] buffer = null;
            int numberOfBytes = 0;
            int index = 0;
            boolean flag = true;

            while (true) {
                if (flag){
                    try {
                        byte[] temp = new byte[inputStream.available()];
                        if (inputStream.read(temp)>0){
                            numberOfBytes = Integer.parseInt(new String(temp, "UTF-8"));
                            buffer = new byte[numberOfBytes];
                            flag = false;
                        }

                    } catch (IOException e) {
                        connectionLost();
                        ChatController.this.start();
                        break;
                    }
                }else {
                    try{
                        byte[] data = new byte[inputStream.available()];
                        int numbers = inputStream.read(data);
                        System.arraycopy(data, 0, buffer, index, numbers);
                        index = index + numbers;
                        if (index == numberOfBytes){
                            handler.obtainMessage(MainActivity.MESSAGE_READ, numberOfBytes, -1, buffer).sendToTarget();
                            flag = true;
                        }
                    }catch (IOException e){
                        connectionLost();
                        ChatController.this.start();
                        break;
                    }
                }
            }
        }

