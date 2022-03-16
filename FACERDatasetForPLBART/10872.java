    private Point alphaToPoint(int alpha) {

        final RectF rect = mAlphaRect;
        final float width = rect.width();

        Point p = new Point();

        p.x = (int) (width - (alpha * width / 0xff) + rect.left);
        p.y = (int) rect.top;

        return p;

    }

