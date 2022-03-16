    /**
     * Method that performs a test over a known parse result.
     *
     * @throws Exception If test failed
     * {@link ListCommand#parse(String, String)}
     */
    @SuppressWarnings("static-method")
    @SmallTest
    public void testParse() throws Exception {
        MountPointInfoCommand cmd = new MountPointInfoCommand();
        String in = "rootfs / rootfs ro,relatime 0 0\n" + //$NON-NLS-1$
                    "tmpfs /dev tmpfs rw,nosuid,relatime,mode=755 0 0\n" + //$NON-NLS-1$
                    "devpts /dev/pts devpts rw,relatime,mode=600 0 0\n" + //$NON-NLS-1$
                    "/dev/block/vold/179:25 /mnt/emmc vfat rw,dirsync,nosuid,nodev," //$NON-NLS-1$
                    + "noexec,relatime,uid=1000,gid=1015,fmask=0702,dmask=0702," //$NON-NLS-1$
                    + "allow_utime=0020,codepage=cp437,iocharset=iso8859-1," //$NON-NLS-1$
                    + "shortname=mixed,utf8,errors=remount-ro 0 0"; //$NON-NLS-1$
        String err = ""; //$NON-NLS-1$
        cmd.parse(in, err);
        List<MountPoint> mp = cmd.getResult();
        assertNotNull("mountpoints==null", mp); //$NON-NLS-1$
        assertTrue("length!=4", mp.size() == 4); //$NON-NLS-1$
        assertTrue(
                "mountpoints(1).device!=tmpfs", //$NON-NLS-1$
                mp.get(1).getDevice().compareTo("tmpfs") == 0); //$NON-NLS-1$
        assertTrue(
                "mountpoints(2).mountpoint!=/dev/pts",  //$NON-NLS-1$
                mp.get(2).getMountPoint().compareTo("/dev/pts") == 0); //$NON-NLS-1$
        assertTrue(
                "mountpoints(3).type!=vfat",  //$NON-NLS-1$
                mp.get(3).getType().compareTo("vfat") == 0); //$NON-NLS-1$
        assertTrue(
                "mountpoints(0).options!=ro,relatime",  //$NON-NLS-1$
                mp.get(0).getOptions().compareTo("ro,relatime") == 0); //$NON-NLS-1$
        assertTrue(
                "mountpoints(0).dump!=0", //$NON-NLS-1$
                mp.get(0).getDump() == 0);
        assertTrue(
                "mountpoints(0).pass!=0", //$NON-NLS-1$
                mp.get(0).getPass() == 0);
    }

