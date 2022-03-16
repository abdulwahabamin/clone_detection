        public void run() {
            mByteArray[0] = (byte) mReceiveType;
            for (int i = 0; i < connections.size(); i++) {
                if (i + 1 != mSenderId) {
                    connections.get(i).write(mByteArray);
                }
            }
        }

