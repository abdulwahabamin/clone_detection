        @Override
        protected void onProgressUpdate(Integer... values) {
            updateHeaderView();
            headerLayoutParams.topMargin=values[0];
            header.setLayoutParams(headerLayoutParams);
        }

