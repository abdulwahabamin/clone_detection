    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView rv, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, rv, state);

        debugLog("getItemOffsets");

        debugLog("View top = " + view.getTop());
        if (selectedDragItemPos != -1) {
            int itemPos = rv.getChildLayoutPosition(view);
            debugLog("itemPos =" + itemPos);

            if (!canDragOver(itemPos)) {
                return;
            }

            //Movement of finger
            float totalMovement = fingerY - fingerAnchorY;

            if (itemPos == selectedDragItemPos) {
                view.setVisibility(View.INVISIBLE);
            } else {
                //Make view visible incase invisible
                view.setVisibility(View.VISIBLE);

                //Find middle of the floatingItem
                float floatMiddleY = floatingItemBounds.top + floatingItemBounds.height() / 2;

                //Moving down the list
                //These will auto-animate if the device continually sends touch motion events
                // if (totalMovment>0)
                {
                    if ((itemPos > selectedDragItemPos) && (view.getTop() < floatMiddleY)) {
                        float amountUp = (floatMiddleY - view.getTop()) / (float) view.getHeight();
                        //  amountUp *= 0.5f;
                        if (amountUp > 1)
                            amountUp = 1;

                        outRect.top = -(int) (floatingItemBounds.height() * amountUp);
                        outRect.bottom = (int) (floatingItemBounds.height() * amountUp);
                    }

                }//Moving up the list
                // else if (totalMovment < 0)
                {
                    if ((itemPos < selectedDragItemPos) && (view.getBottom() > floatMiddleY)) {
                        float amountDown = ((float) view.getBottom() - floatMiddleY) / (float) view.getHeight();
                        //  amountDown *= 0.5f;
                        if (amountDown > 1)
                            amountDown = 1;

                        outRect.top = (int) (floatingItemBounds.height() * amountDown);
                        outRect.bottom = -(int) (floatingItemBounds.height() * amountDown);
                    }
                }
            }
        } else {
            outRect.top = 0;
            outRect.bottom = 0;
            //Make view visible incase invisible
            view.setVisibility(View.VISIBLE);
        }
    }

