        @Override
        protected void onPostExecute(final Task task) {
            task.doOnMainThread();
            handler.executeAsync(new Runnable() {
                @Override
                public void run() {onTaskComplete(task);
                }
            }, ON_COMPLETE_THREAD);
        }

