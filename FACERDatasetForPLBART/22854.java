        @Override
        public void run() {

            //run every 100 ms
            postDelayed(this, 120);

            invalidate();
        }

