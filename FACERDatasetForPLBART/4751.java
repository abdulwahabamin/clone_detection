        @Override
        public boolean onInterceptTouchEvent(MotionEvent event) {
            float x=event.getX();
            if(x>(viewWidth/4) && x< viewWidth-(viewWidth/4))
                ImageSliderPager.setPagingEnabled(false);
            else
                ImageSliderPager.setPagingEnabled(true);


            if (enabled) {
                return super.onInterceptTouchEvent(event);
            }

            return false;
        }

