        @Override
        protected void onPostExecute(Integer integer) {
            headerLayoutParams.topMargin=integer;
            header.setLayoutParams(headerLayoutParams);
            updateIndicationImage.setVisibility(View.GONE);
            lastStatus=currentStatus=STATUS_REFRESH_FINISHED;
        }

