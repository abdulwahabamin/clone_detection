        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            }
            catch(Exception e)
            {}
            Intent intn=new Intent(MainActivity.this,MainPage.class);
            startActivity(intn);

        }

