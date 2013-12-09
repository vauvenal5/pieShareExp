/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pietools.pieutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author richy
 */
public class PieLogger {

    private static final Logger log = LoggerFactory.getLogger(PieLogger.class);

    public static void debug(String message) {

        log.debug(message);
    }
    
    public static void error(String message) {

        log.error(message);
    }
    
    public static void info(String message) {

        log.info(message);
    }

}
