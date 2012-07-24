/*
 * Copyright (C) 2012 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package juzu.impl.router.regex;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public abstract class REFactory implements Cloneable {

  public static REFactory JAVA = new REFactory() {
    @Override
    public RE compile(String pattern) {
      return new RE.Java(pattern);
    }

    @Override
    public String getName() {
      return "java";
    }
  };

  protected REFactory() {
  }

  public abstract RE compile(String pattern);

  public abstract String getName();
}
