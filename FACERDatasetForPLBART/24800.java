        @Override
        public boolean onTouch(View view, MotionEvent event) {

            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    isTouch =true;
                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    lastPosition = (int) view.getY();
                    IsUp = isUp();
                    break;
                case MotionEvent.ACTION_UP:
                    isTouch =false;
                    nowPosition = (int) view.getY();
                    if (lastPosition==nowPosition)
                    {
                        if (!IsUp)
                        {goUp();}
                    }
                    else
                    if (getSlideUporBottom(lastPosition, nowPosition)) {
                        if (IsUp)
                            goDown();
                        else
                            goUp();
                    } else {
                        if (ScreenHeight / 2 < view.getY()) {
                            goDown();
                        } else
                            goUp();
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    isTouch =true;
                    int gety = (int) (event.getRawY() + dY);
                    if (gety < -getValues.dpToPx(mMiniMusicplayerheight)) {
                        gety = -getValues.dpToPx(mMiniMusicplayerheight);
                    }
                    if (gety > ScreenHeight - getValues.dpToPx(mMiniMusicplayerheight)) {
                        gety = (int) (ScreenHeight - getValues.dpToPx(mMiniMusicplayerheight));
                    }
                    view.animate()
                            .y(gety)
                            .setDuration(0)
                            .setInterpolator(new AccelerateInterpolator())
                            .start();
                    if (view.getY() < ((ScreenHeight + getValues.dpToPx(mMiniMusicplayerheight)) / 2)) {
                        float percentage = Math.abs(view.getY()+getValues.dpToPx(mMiniMusicplayerheight)) / ((ScreenHeight + getValues.dpToPx(mMiniMusicplayerheight)) / 2);
                        //percentage=percentage*2;
                        mMiniMusicPlayer.animate()
                                .alpha(percentage)
                                .setDuration(0)
                                .setInterpolator(new AccelerateInterpolator())
                                .start();
                    }
                    break;
                default:
                    return false;
            }
            return true;
        }

