        public void write(byte[] buffer, String tipo_mensaje) {
            if (tipo_mensaje.equals("texto")){
                try {
                    outputStream.write(buffer);
                    handler.obtainMessage(MainActivity.MESSAGE_WRITE, -1, -1,
                            buffer).sendToTarget();
                } catch (IOException e) {
                }
            }
            if (tipo_mensaje.equals("imagen")){
                try {
                    outputStream.write(buffer);
                    outputStream.flush();
                } catch (IOException e) {
                }
            }
        }

