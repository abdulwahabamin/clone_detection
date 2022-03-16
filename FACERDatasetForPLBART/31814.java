    private void drawButtons(Canvas c, RecyclerView.ViewHolder viewHolder) {

        if (!(viewHolder instanceof LocationsActivity.LocationHolder)) {
            return;
        }

        LocationsActivity.LocationHolder locationHolder = (LocationsActivity.LocationHolder) viewHolder;

        float buttonWidthWithoutPadding = buttonWidth - 20;
        float corners = 16;

        View itemView = viewHolder.itemView;
        Paint p = new Paint();

        /*RectF leftButton = new RectF(itemView.getLeft(), itemView.getTop(), itemView.getLeft() + buttonWidthWithoutPadding, itemView.getBottom());
        p.setColor(Color.BLUE);
        c.drawRoundRect(leftButton, corners, corners, p);
        drawText("EDIT", c, leftButton, p);*/

        RectF rightButton;
        if (locationHolder.getLocation().getOrderId() == 0) {
            rightButton = new RectF(itemView.getRight() - buttonWidthWithoutPadding, itemView.getTop(), itemView.getRight(), itemView.getBottom());
            p.setColor(Color.rgb(85, 170, 0));
            c.drawRoundRect(rightButton, corners, corners, p);
            if (locationHolder.getLocation().isEnabled()) {
                drawText(context.getString(R.string.locations_disable_location), c, rightButton, p);
            } else {
                drawText(context.getString(R.string.locations_enable_location), c, rightButton, p);
            }
        } else {
            rightButton = new RectF(itemView.getRight() - buttonWidthWithoutPadding, itemView.getTop(), itemView.getRight(), itemView.getBottom());
            p.setColor(Color.RED);
            c.drawRoundRect(rightButton, corners, corners, p);
            drawText(context.getString(R.string.locations_delete_location), c, rightButton, p);
        }

        buttonInstance = null;
        /*if (buttonShowedState == ButtonsState.LEFT_VISIBLE) {
            buttonInstance = leftButton;
        }
        else*/ if (buttonShowedState == ButtonsState.RIGHT_VISIBLE) {
            buttonInstance = rightButton;
        }
    }

