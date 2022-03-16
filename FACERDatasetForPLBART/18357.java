        @Override
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            mHandler.postDelayed(initGridView, 200);

        }

