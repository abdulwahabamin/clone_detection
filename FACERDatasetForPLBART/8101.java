    private Point hueToPoint(float hue) {

        final RectF rect = mHueRect;
        final float height = rect.height();

        Point p = new Point();

        p.y = (int) (height - (hue * height / 360f) + rect.top);
        p.x = (int) rect.left;

        return p;
    }

