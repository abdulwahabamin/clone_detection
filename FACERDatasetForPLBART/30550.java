    private void drawDashLine(List<Float> dashWidth, List<Float> dashHeight, Canvas canvas) {
        if (dashHeight != null && dashHeight.size() > 1) {
            for (int i = 1; i < dashHeight.size() - 1; i++) {
                canvas.drawLine(dashWidth.get(i), dashHeight.get(i) + 3, dashWidth.get(i), baseLineHeight, dashPaint);
            }
        }
    }

