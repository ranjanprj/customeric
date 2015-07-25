/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.com.bc.wicket.utils;

/**
 *
 * @author RanjanPr
 */
public final class Utilities {
    
    private Utilities() {
    }
    
    public static Utilities getInstance() {
        return UtilitiesHolder.INSTANCE;
    }
    
    private static class UtilitiesHolder {

        private static final Utilities INSTANCE = new Utilities();
    }
    
    
}
