        private void drawUsed(Rect rect, int stroke, float used) {
            // Draw used
            DrawingObject drawingObject = createDrawingObject(rect, "disk_usage_used_color", stroke);
            synchronized (LOCK) {
                mDrawingObjects.add(drawingObject);
            }
            while (drawingObject.mSweepAngle < used) {
                drawingObject.mSweepAngle++;
                redrawCanvas();
                sleepyTime();
            }
        }

