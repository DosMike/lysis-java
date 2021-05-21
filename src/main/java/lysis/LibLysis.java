package lysis;

import lysis.builder.SourceBuilder;
import lysis.lstructure.Function;

import java.io.*;

/**
 * This class is holding methods that can be used to decompile files without relying on dumping onto std.out
 */
public class LibLysis {

    /**
     * Decompiles a plugin file into memory and returns the string representation.
     * Any non-critical errors encountered will be dumped to System.err.
     * @param filename the file as string path to be decompiled
     * @return the decompiled source
     */
    public static String getDecompiled(String filename) throws Exception {
        try (FileInputStream fis = new FileInputStream(filename)) {
            return getDecompiled(fis);
        }
    }
    /**
     * Decompiles a plugin file into memory and returns the string representation.
     * Any non-critical errors encountered will be dumped to System.err.
     * @param source the file to be decompiled
     * @return the decompiled source
     */
    public static String getDecompiled(File source) throws Exception {
        try (FileInputStream fis = new FileInputStream(source)) {
            return getDecompiled(fis);
        }
    }
    /**
     * Decompiles a plugin file into memory and returns the string representation.
     * Any non-critical errors encountered will be dumped to System.err.
     * @param stream the source stream from where to decompile
     * @return the decompiled source
     */
    public static String getDecompiled(InputStream stream) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        decompile(stream, baos);
        return baos.toString("UTF-8");
    }
    /**
     * Wrapper that decompiles a plugin from one file to another.
     * @param source the compiled file
     * @param target where to compile to. If the file already exists it's contents will be replaced
     */
    public static void decompileFile(File source, File target) throws Exception {
        try (FileInputStream in = new FileInputStream(source); FileOutputStream out = new FileOutputStream(target)) {
            decompile(in, out);
        }
    }
    /**
     * Decompiles a plugin file from one stream to another.
     * Any non-critical errors encountered will be dumped to System.err.
     * @param stream the source stream from where to decompile
     * @param target the destination stream for the decompiled code
     */
    public static void decompile(InputStream stream, OutputStream target) throws Exception {
        PrintStream pw = new PrintStream(target, false, "UTF-8");
        decompile(stream, pw);
    }
    /**
     * Decompiles a plugin file from one stream to another.
     * Any non-critical errors encountered will be dumped to System.err.
     * @param stream the source stream from where to decompile
     * @param target the destination stream for the decompiled code
     */
    public static void decompile(InputStream stream, PrintStream target) throws Exception {
        PawnFile file = PawnFile.FromSource(stream);

        // Parse methods for calls and globals which don't have debug info attached.
        for (int i = 0; i < file.functions().length; i++) {
            Function fun = file.functions()[i];
            try {
                Lysis.PreprocessMethod(file, fun);
            } catch (Throwable e) {
                e.printStackTrace();
                System.err.println("");
                System.err.println("/* ERROR PREPROCESSING! " + e.getMessage() + " */");
                System.err.println(" function \"" + fun.name() + "\" (number " + i + ")");
            }
        }

        SourceBuilder source = new SourceBuilder(file, target);
        try {
            source.writeGlobals();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        for (int i = 0; i < file.functions().length; i++) {
            Function fun = file.functions()[i];
            try {
                Lysis.DumpMethod(file, source, fun);
                //System.err.println(""); //?
            } catch (Throwable e) {
                e.printStackTrace();
                System.err.println("");
                System.err.println("/* ERROR! " + e.getMessage() + " */");
                System.err.println(" function \"" + fun.name() + "\" (number " + i + ")");
                source = new SourceBuilder(file, target);
            }
        }

        target.flush();
    }

}
