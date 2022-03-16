        private void redrawCanvas() {
            //Redraw the canvas
            post(new Runnable() {
                @Override
                public void run() {
                    invalidate();
                }
            });
        }

