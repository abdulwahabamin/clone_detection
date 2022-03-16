    public static Method getMethod(Class<?> classObject, String methodName) {
        try {
            return classObject.getMethod(methodName, boolean.class);
        } catch (NoSuchMethodException e) {
            //Log.i(B.LOG_TAG, "Can't get method " +
            //      classObject.toString() + "." + methodName);
        } catch (Exception e) {
            //BLog.add("B() Error while using reflection to get method " + classObject.toString() + "." + methodName, e);
        }
        return null;
    }

