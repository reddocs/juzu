package org.juzu.portlet;

import org.juzu.URLBuilder;

import javax.portlet.BaseURL;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
class URLBuilderImpl implements URLBuilder
{

   /** . */
   private final BaseURL url;

   URLBuilderImpl(BaseURL url)
   {
      this.url = url;
   }

   public URLBuilder setParameter(String name, String value)
   {
      url.setParameter(name, value);
      return this;
   }

   @Override
   public String toString()
   {
      return url.toString();
   }
}
