/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepyjama.ihstech.CueNet.osc;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPort;
import com.illposed.osc.OSCPortOut;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author buckbanzai
 */
public class OSCSender {
    /**
     * Sends OSC messages to the desired device
     * @param ip            The device's IP
     * @param port          The OSC Server's port
     * @param oscaddress    The OSC address
     * @param value         The Value between 0 and 255
     */
    public static void sendOSC(String ip, int port, String oscaddress, int value){
        OSCPortOut sender;
        try {
            sender = new OSCPortOut(java.net.InetAddress.getByName(ip),port);
        } catch (Exception ex) {
            sender = null;
        }
	Object argus[] = new Object[2];
	argus[0] = new Integer(3);
	argus[1] = value;
	OSCMessage msg = new OSCMessage(oscaddress, argus);
	 try {
		sender.send(msg);
	 } catch (Exception e) {
		 Logger.getLogger(OSCSender.class.getName()).log(Level.SEVERE, null, e);
	 }
    }
}
