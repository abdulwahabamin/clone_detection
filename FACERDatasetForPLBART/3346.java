        @Override
        public void uncaughtException(Thread thread, Throwable exception) {
            final StringWriter stackTrace = new StringWriter();
            exception.printStackTrace(new PrintWriter(stackTrace));
            //System.err.println(stackTrace);
            BLog.e(stackTrace.toString());

            Intent intent = new Intent(myContext, Main.class);
            intent.putExtra(Main.INTENT_DATE_STACKTRACE, stackTrace.toString());
            myContext.startActivity(intent);

            try {
                myContext.startActivity(intent);
            } catch (ActivityNotFoundException e) {

            }
            if (myContext instanceof Activity) {
                ((Activity)myContext).finish();
            }
            Process.killProcess(Process.myPid());
            System.exit(10);
        }

