        @Override
        void setupSetter(Class targetClass) {
            if (mProperty != null) {
                return;
            }
            // Check new static hashmap<propName, int> for setter method
            //try {
            //    mPropertyMapLock.writeLock().lock();
            //    HashMap<String, Integer> propertyMap = sJNISetterPropertyMap.get(targetClass);
            //    if (propertyMap != null) {
            //        Integer mJniSetterInteger = propertyMap.get(mPropertyName);
            //        if (mJniSetterInteger != null) {
            //            mJniSetter = mJniSetterInteger;
            //        }
            //    }
            //    if (mJniSetter == 0) {
            //        String methodName = getMethodName("set", mPropertyName);
            //        mJniSetter = nGetFloatMethod(targetClass, methodName);
            //        if (mJniSetter != 0) {
            //            if (propertyMap == null) {
            //                propertyMap = new HashMap<String, Integer>();
            //                sJNISetterPropertyMap.put(targetClass, propertyMap);
            //            }
            //            propertyMap.put(mPropertyName, mJniSetter);
            //        }
            //    }
            //} catch (NoSuchMethodError e) {
            //    Log.d("PropertyValuesHolder",
            //            "Can't find native method using JNI, use reflection" + e);
            //} finally {
            //    mPropertyMapLock.writeLock().unlock();
            //}
            //if (mJniSetter == 0) {
                // Couldn't find method through fast JNI approach - just use reflection
                super.setupSetter(targetClass);
            //}
        }

