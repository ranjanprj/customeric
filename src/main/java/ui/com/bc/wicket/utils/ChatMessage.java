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
import java.io.Serializable;

public class ChatMessage implements Serializable
{

    private String receiver;
    private String message;

    public ChatMessage(String receiver, String message)
    {
        this.receiver = receiver;
        this.message = message;
    }

    public String getReceiver()
    {
        return receiver;
    }

    public String getMessage()
    {
        return message;
    }
}