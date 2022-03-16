        protected Void doInBackground(String... args){
            try{
                connectToServerThread.commsThread.write(args[0]);
            } catch (Exception e){
                Log.d("MainActivity", e.getLocalizedMessage());
            }
            return null;
        }

