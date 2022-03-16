        private void drawTotal(Rect rect, int stroke) {
            // Draw total
            DrawingObject drawingObject = createDrawingObject(rect, "disk_usage_total_color",
                    stroke);
            synchronized (LOCK) {
                mDrawingObjects.add(drawingObject);
            }
            while (drawingObject.mSweepAngle < 360) {
                drawingObject.mSweepAngle++;
                redrawCanvas();
                sleepyTime();
            }
        }

