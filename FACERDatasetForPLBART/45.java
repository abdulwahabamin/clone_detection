        public void writeMessage(String msg)
        {
            try {
                out.write(msg.getBytes());
            }
            catch(Exception e)
            {}
        }

