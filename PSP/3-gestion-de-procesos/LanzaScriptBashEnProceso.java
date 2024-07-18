/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.marcdevelopez.lanzascriptbashenproceso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marc
 */
public class LanzaScriptBashEnProceso {

    static File tempScript;

    public static void main(String[] args) {
        try {
            tempScript = createTempScript();
            ProcessBuilder pb = new ProcessBuilder("bash", tempScript.toString());
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
        } catch (IOException ex) {
            Logger.getLogger(LanzaScriptBashEnProceso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(LanzaScriptBashEnProceso.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            tempScript.delete();
        }

    }

    public static File createTempScript() throws IOException {
        File tempScript = File.createTempFile("script", null);

        Writer streamWriter = new OutputStreamWriter(new FileOutputStream(
                tempScript));
        PrintWriter printWriter = new PrintWriter(streamWriter);

        printWriter.println("#!/bin/bash");
        printWriter.println("cd /");
        printWriter.println("ls -a");

        printWriter.close();

        return tempScript;
    }
}
