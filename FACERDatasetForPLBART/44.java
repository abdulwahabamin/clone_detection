        @Override
        public void run() {
            byte[] b=new byte[100];
            while(true)
            {
                try {
                    in.read(b);
                    String msg = new String(b).trim();
                    if (!msg.equals("")) {
                        h.obtainMessage(2, msg).sendToTarget();
                    }
                    for (int i = 0; i <100; i++) {
                        b[i] = ' ';
                    }
                }
                catch(Exception e)
                {}
            }
        }

