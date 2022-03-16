    private static String msgForTextLog(int logLevel, Object obj, String filename, int line,
                                        String thread, String msg) {
        StringBuilder sb = new StringBuilder();

        switch (logLevel) {
            case LogOptions.LEVEL_VERBOSE:
                sb.append("V/: ");
                break;
            case LogOptions.LEVEL_DEBUG:
                sb.append("D/: ");
                break;
            case LogOptions.LEVEL_INFO:
                sb.append("I/: ");
                break;
            case LogOptions.LEVEL_WARN:
                sb.append("W/: ");
                break;
            case LogOptions.LEVEL_ERROR:
                sb.append("E/: ");
                break;
            default:
                sb.append("I/: ");
                break;
        }

        sb.append("[");
        sb.append(objClassName(obj));
        sb.append("]");

        sb.append(msg);
        sb.append("(P:");
        sb.append(Process.myPid());
        sb.append(")");
        sb.append("(T:");

        if (thread != null){
            sb.append(thread);
        }else {
            if (Looper.getMainLooper() == Looper.myLooper())
                sb.append("Main");
            else
                sb.append(Thread.currentThread().getId());
        }
        sb.append(")");

        if (line > 0) {
            sb.append("at (");
            sb.append(filename);
            sb.append(":");
            sb.append(line);
            sb.append(")");
        }
        String ret = sb.toString();
        return ret;
    }

