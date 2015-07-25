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
import org.apache.wicket.Session;
import org.apache.wicket.atmosphere.AtmosphereEvent;

import com.google.common.base.Predicate;

public class ReceiverFilter implements Predicate<AtmosphereEvent>
{
    public ReceiverFilter()
    {
    }

    @Override
    public boolean apply(AtmosphereEvent input)
    {
        if (input.getPayload() instanceof ChatMessage)
        {
            ChatMessage msg = (ChatMessage)input.getPayload();
            return msg.getReceiver() == null || msg.getReceiver().isEmpty() ||
                msg.getReceiver().equals(Session.get().getId());
        }
        return false;
    }
}