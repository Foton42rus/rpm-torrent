package com.jbittorrent.utilityclasses;

import java.nio.charset.Charset;
import java.util.StringTokenizer;

/**
 * Some useful (or not...) constants used (or not yet...) throughout the program
 */
public class
        Constants {
    public static final String DEFAULT_ENCODING = "UTF8";
    public static final String BYTE_ENCODING = "ISO-8859-1";
    public static Charset BYTE_CHARSET;
    public static Charset DEFAULT_CHARSET;

    static {
        try {

            BYTE_CHARSET = Charset.forName(Constants.BYTE_ENCODING);
            DEFAULT_CHARSET = Charset.forName(Constants.DEFAULT_ENCODING);

        } catch (Throwable e) {

            e.printStackTrace();
        }
    }

    public static final String CLIENT = "jBittorrentAPI 1.0";
    public static String SAVEPATH = "downloads/";

    public static final String OSName = System.getProperty("os.name");

    public static final boolean isOSX = OSName.toLowerCase().startsWith(
            "mac os");
    public static final boolean isLinux = OSName.equalsIgnoreCase("Linux");
    public static final boolean isSolaris = OSName.equalsIgnoreCase("SunOS");
    public static final boolean isFreeBSD = OSName.equalsIgnoreCase("FreeBSD");
    public static final boolean isWindowsXP = OSName.equalsIgnoreCase(
            "Windows XP");
    public static final boolean isWindows95 = OSName.equalsIgnoreCase(
            "Windows 95");
    public static final boolean isWindows98 = OSName.equalsIgnoreCase(
            "Windows 98");
    public static final boolean isWindowsME = OSName.equalsIgnoreCase(
            "Windows ME");
    public static final boolean isWindows9598ME = isWindows95 || isWindows98 ||
                                                  isWindowsME;
    public static final boolean isWindows = OSName.toLowerCase().startsWith(
            "windows");
    public static final String JAVA_VERSION = System.getProperty("java.version");
}
