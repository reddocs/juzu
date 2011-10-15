package org.juzu.impl.request;

import org.juzu.application.Phase;

import java.util.Map;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public final class RenderContext extends MimeContext<RenderBridge>
{

   public RenderContext(ClassLoader classLoader, RenderBridge bridge)
   {
      super(classLoader, bridge);
   }

   @Override
   public Phase getPhase()
   {
      return Phase.RENDER;
   }

   @Override
   public Map<Object, Object> getContext(Scope scope)
   {
      switch (scope)
      {
         case FLASH:
            return bridge.getFlashContext();
         case MIME:
         case RENDER:
         case REQUEST:
            return bridge.getRequestContext();
         case ACTION:
         case RESOURCE:
            return null;
         case SESSION:
            return bridge.getSessionContext();
         case IDENTITY:
            return bridge.getIdentityContext();
         default:
            throw new AssertionError();
      }
   }
}
