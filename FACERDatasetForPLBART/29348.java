        @Override
        protected Void doInBackground(Void... params) {
            currentStatus=STATUS_REFRESHING;
            int topMargin=headerLayoutParams.topMargin;
            SCROLL_SPEED=-topMargin/3;
            while(true){
                SCROLL_SPEED+=-5;
                topMargin=topMargin+SCROLL_SPEED;
                if(topMargin<=0){
                    break;
                }
                publishProgress(topMargin);
                sleep(1);
            }
            publishProgress(0);
            if(mListener!=null){
                mListener.onRefresh();
                sleep(500);
            }
            return null;
        }

