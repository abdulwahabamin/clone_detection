        private void drawUsedWithColors(Rect rect, int stroke) {
            // Draw used segments
            if (mDiskUsage != null) {
                int lastSweepAngle = 0;
                float catUsed = 100.0f;
                int color;
                int index = 0;
                for (DiskUsageCategory category : mDiskUsage.getUsageCategoryList()) {
                    catUsed = (category.getSizeBytes() * 100) / mDiskUsage.getTotal(); // calc percent
                    catUsed = (catUsed < 1) ? 1 : catUsed; // Normalize
                    catUsed = (360 * catUsed) / 100; // calc angle

                    // Figure out a color
                    if (index > -1 && index < COLOR_LIST.size()) {
                        color = COLOR_LIST.get(index);
                        index++;
                    } else {
                        index = 0;
                        color = COLOR_LIST.get(index);
                    }

                    DrawingObject drawingObject = createDrawingObjectNoTheme(rect, color, stroke);
                     drawingObject.mStartAngle += lastSweepAngle;
                    synchronized (LOCK) {
                        mDrawingObjects.add(drawingObject);
                    }
                    while (drawingObject.mSweepAngle < catUsed + SLOP) {
                        drawingObject.mSweepAngle++;
                        redrawCanvas();
                        sleepyTime();
                    }
                    lastSweepAngle += drawingObject.mSweepAngle - SLOP;
                }
            }
        }

