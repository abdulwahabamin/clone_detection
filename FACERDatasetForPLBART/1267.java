        public void cancel() {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }

