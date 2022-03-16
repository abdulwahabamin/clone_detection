    public static void apply(SharedPreferences.Editor editor) {
        if (sApplyMethod != null) {
            try {
                sApplyMethod.invoke(editor);
                return;
            } catch (InvocationTargetException unused) {
                //$FALL-THROUGH$
            } catch (IllegalAccessException unused) {
                //$FALL-THROUGH$
            }
        }
        editor.commit();
    }

