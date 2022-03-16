        @Override
        protected void onPostExecute(Boolean result) {

            SERVICE.isMoving=false;
            Bgo.refreshCurrentFragment(SERVICE.activity);
        }

