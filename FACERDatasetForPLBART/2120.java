        @Override
        public void isVisible(Boolean visible) {
            if (visible) {
                runTasks();
            } else {
                interruptTasks();
            }
        }

