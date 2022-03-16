        @Override
        protected Integer doInBackground(Void... params) {
            if(currentStatus!=STATUS_PULL_TO_REFRESH){
                sleep(500);
            }
            int topMargin=headerLayoutParams.topMargin;
            SCROLL_SPEED=-40;
            while(true){
                SCROLL_SPEED+=-5;
                topMargin=topMargin+SCROLL_SPEED;
                if(topMargin<=hideHeaderHeight){
                    topMargin=hideHeaderHeight;
                    break;
                }
                publishProgress(topMargin);
                sleep(1);
            }
            return topMargin;
        }

