    static float calculateMaxRadius(View view) {
        float widthSquared = view.getWidth() * view.getWidth();
        float heightSquared = view.getHeight() * view.getHeight();
        float radius = (float) Math.sqrt(widthSquared + heightSquared) / 2;
        return radius;
    }

